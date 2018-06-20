package net.lunar.hypnos.interceptor;

import java.util.Collection;

import org.beetl.sql.core.InterceptorContext;
import org.beetl.sql.ext.DebugInterceptor;

public class DebugLogInterceptor extends DebugInterceptor {

	@Override
	public void before(InterceptorContext ctx) {
		String sqlId = ctx.getSqlId();
		if (this.isDebugEanble(sqlId)) {
			ctx.put("debug.time", System.currentTimeMillis());
		}
		if (this.isSimple(sqlId)) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		String lineSeparator = System.getProperty("line.separator", "\n");
		
		sb.append("┏━━━━━ SQLDebug模式日志输出开始: [").append(this.getSqlId(formatSql(sqlId))).append("] ━━━━━━━").append(lineSeparator);
		sb.append("┣ SQL:\t").append(formatSql(ctx.getSql())).append(lineSeparator);
		sb.append("┣ 参数:\t").append(formatParas(ctx.getParas())).append(lineSeparator);
		
		RuntimeException ex = new RuntimeException();
		StackTraceElement[] traces = ex.getStackTrace();
		int index = lookBusinessCodeInTrace(traces);
		StackTraceElement bussinessCode = traces[index];
		String className = bussinessCode.getClassName();
		String mehodName = bussinessCode.getMethodName();
		int line = bussinessCode.getLineNumber();
		sb.append("┣ 调用:\t").append(className).append(".").append(mehodName)
		.append("(").append(bussinessCode.getFileName()).append(":").append(line).append(")")
		.append(lineSeparator);

		ctx.put("logs", sb);
	}

	@Override
	public void after(InterceptorContext ctx) {
		String sqlId = ctx.getSqlId();
		if (this.isSimple(sqlId)) {
			this.simpleOut(ctx);
			return;
		}
		long time = System.currentTimeMillis();
		long start = (Long) ctx.get("debug.time");
		String lineSeparator = System.getProperty("line.separator", "\n");
		StringBuilder sb = (StringBuilder) ctx.get("logs");
		sb.append("┣ 耗时:\t" + (time - start) + "ms").append(lineSeparator);
		if (ctx.isUpdate()) {
			sb.append("┣ 条数:\t[");
			if (ctx.getResult().getClass().isArray()) {
				int[] ret = (int[]) ctx.getResult();
				for (int i = 0; i < ret.length; i++) {
					if (i > 0)
						sb.append(",");
					sb.append(ret[i]);
				}
			} else {
				sb.append(ctx.getResult());
			}
			sb.append("]").append(lineSeparator);
		} else {
			if (ctx.getResult() instanceof Collection) {
				sb.append("┣ 返回:\t[").append(((Collection) ctx.getResult()).size()).append("]").append(lineSeparator);
			} else {
				sb.append("┣ 返回:\t[").append(ctx.getResult()).append("]").append(lineSeparator);
			}

		}
		sb.append("┗━━━━━ SQLDebug模式日志输出结束: [").append(this.getSqlId(formatSql(ctx.getSqlId()))).append("] ━━━━━━━")
				.append(lineSeparator);
		println(sb.toString());
		
	}

	@Override
	public void exception(InterceptorContext ctx, Exception ex) {
		String sqlId = ctx.getSqlId();
		if (this.isSimple(sqlId)) {
			this.simpleOutException(ctx, ex);
			return;
		}
		String lineSeparator = System.getProperty("line.separator", "\n");
		StringBuilder sb = (StringBuilder) ctx.get("logs");
		sb.append("┗━━━━━ SQLDebug模式日志输出结束: [ 错误:").append(ex != null ? ex.getMessage().replace(lineSeparator, "") : "")
				.append("] ━━━━━━━").append(lineSeparator);
		println(sb.toString());
		
	}

}
