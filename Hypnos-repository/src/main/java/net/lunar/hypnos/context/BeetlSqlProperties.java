package net.lunar.hypnos.context;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="hypnos")
public class BeetlSqlProperties {
	private String basePackage;
	
	private String mapperSuffix;
	
	private String dialect;
	
	private boolean showSqlDebug;
	
	private String mapperSource;
	
	public BeetlSqlProperties() {
		System.out.println("BeetlSqlProperties construction-->" + this);
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		System.out.println("set basepkg..." + basePackage);
		this.basePackage = basePackage;
	}

	public String getMapperSuffix() {
		return mapperSuffix;
	}

	public void setMapperSuffix(String mapperSuffix) {
		this.mapperSuffix = mapperSuffix;
	}

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		System.out.println("set di..." + dialect);
		this.dialect = dialect;
	}

	public boolean isShowSqlDebug() {
		return showSqlDebug;
	}

	public void setShowSqlDebug(boolean showSqlDebug) {
		this.showSqlDebug = showSqlDebug;
	}

	public String getMapperSource() {
		return mapperSource;
	}

	public void setMapperSource(String mapperSource) {
		this.mapperSource = mapperSource;
	}
	
}
