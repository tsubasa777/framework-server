package net.lunar.hypnos.interceptor;

import org.beetl.sql.core.InterceptorContext;
import org.beetl.sql.ext.DebugInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DefaultLogInterceptor extends DebugInterceptor{

	private Logger log =  LoggerFactory.getLogger(this.getClass());

	@Override
	public void before(InterceptorContext ctx) {
		String sqlId = ctx.getSqlId();
		if (this.isDebugEanble(sqlId)) {
			ctx.put("debug.time", System.currentTimeMillis());
		}
		if (this.isSimple(sqlId)) {
			return;
		}
		String sql = formatSql(ctx.getSql());
		
		log.info(sql);
	}

	@Override
	public void after(InterceptorContext ctx) {
		
	}

	@Override
	public void exception(InterceptorContext ctx, Exception ex) {
		
	}
	
	
	
}
