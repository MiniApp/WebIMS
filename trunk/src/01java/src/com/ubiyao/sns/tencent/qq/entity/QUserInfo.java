package com.ubiyao.sns.tencent.qq.entity;

import java.io.Serializable;

/**
 * 腾讯微博用户信息
 * http://open.t.qq.com/resource.php?i=1,1#9_30
 * 
 * @author Trinea 2011-10-8 下午11:44:53
 */
public class QUserInfo implements Serializable {

	private static final long serialVersionUID = 3298635316340763420L;

	private String nickName; 		// 用户在QQ空间的昵称。
	private String figureUrl;		// 大小为30×30像素的QQ空间头像URL。
	private String figureUrl1;		// 大小为50×50像素的QQ空间头像URL。
	private String figureUrl2;		// 大小为100×100像素的QQ空间头像URL。
	private String figureUrlQq1;	// 大小为40×40像素的QQ头像URL。
	private String figureUrlQq2;	// 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。
	private String gender;			// 性别。 如果获取不到则默认返回"男"
	private String isYellowVip;	// 标识用户是否为黄钻用户（0：不是；1：是）。
	private String vip;				// 标识用户是否为黄钻用户（0：不是；1：是）
	private String yellowVipLevel;// 黄钻等级
	private String level;			// 黄钻等级
	private String isYellowYearVip;// 标识是否为年费黄钻用户（0：不是； 1：是）
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getFigureUrl() {
		return figureUrl;
	}
	public void setFigureUrl(String figureUrl) {
		this.figureUrl = figureUrl;
	}
	public String getFigureUrl1() {
		return figureUrl1;
	}
	public void setFigureUrl1(String figureUrl1) {
		this.figureUrl1 = figureUrl1;
	}
	public String getFigureUrl2() {
		return figureUrl2;
	}
	public void setFigureUrl2(String figureUrl2) {
		this.figureUrl2 = figureUrl2;
	}
	public String getFigureUrlQq1() {
		return figureUrlQq1;
	}
	public void setFigureUrlQq1(String figureUrlQq1) {
		this.figureUrlQq1 = figureUrlQq1;
	}
	public String getFigureUrlQq2() {
		return figureUrlQq2;
	}
	public void setFigureUrlQq2(String figureUrlQq2) {
		this.figureUrlQq2 = figureUrlQq2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIsYellowVip() {
		return isYellowVip;
	}
	public void setIsYellowVip(String isYellowVip) {
		this.isYellowVip = isYellowVip;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	public String getYellowVipLevel() {
		return yellowVipLevel;
	}
	public void setYellowVipLevel(String yellowVipLevel) {
		this.yellowVipLevel = yellowVipLevel;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getIsYellowYearVip() {
		return isYellowYearVip;
	}
	public void setIsYellowYearVip(String isYellowYearVip) {
		this.isYellowYearVip = isYellowYearVip;
	}
}
