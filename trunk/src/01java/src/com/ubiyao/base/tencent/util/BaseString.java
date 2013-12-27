package com.ubiyao.base.tencent.util;

import java.net.URLEncoder;
import java.util.ArrayList;

/**    
 *         
 * Class Name：
 *			BaseString    
 * Description：    
 *			描述
 * @Author	suhao
 * @Date	2013-12-24 下午5:17:18    
 * @Version	
 *     
 */
public class BaseString {
	
	String url;//请求网址
	String httpMethod;//请求方式
	ArrayList<String> paramNameList;//参数名列表
	ArrayList<String> paramValueList;//参数值列表
	int[] order;//参数名排序
	
	public BaseString(){
		paramNameList=new ArrayList<String>();
		paramValueList=new ArrayList<String>();
		url=null;
		httpMethod=null;
	}
	
	//设置请求网址
	public void setURL(String url){
		this.url=url;
	}
	
	//设置请求方式
	public void setHttpMethod(String httpMethod){
		this.httpMethod=httpMethod;
	}
	
	//添加参数
	public void addParams(String name,String value){
		paramNameList.add(name);
		paramValueList.add(value);
	}
	
	//获取baseString
	public String getBaseString(){
		StringBuffer sb=new StringBuffer();
		try {
			sb.append(httpMethod);
			sb.append("&");
			sb.append(URLEncoder.encode(url, "UTF-8"));
			sb.append("&");
			order();
			int size=paramNameList.size();
			for(int i=0;i<size;i++){
				sb.append(paramNameList.get(order[i]));
				sb.append("%3D");
				sb.append(URLEncoder.encode(paramValueList.get(order[i]),"UTF-8"));
				if(i<size-1){
					sb.append("%26");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	//根据参数名排序
	void order(){
		int size=paramNameList.size();
		order=new int[size];
		String name1;
		String name2;
		for(int i=0;i<size;i++){
			name1=paramNameList.get(i);
			int k=0;
			for(int j=0;j<size;j++){
				name2=paramNameList.get(j);
				if(name1.compareTo(name2)>0){
					k++;
				}
			}
			order[k]=i;
		}
	}
	
}

