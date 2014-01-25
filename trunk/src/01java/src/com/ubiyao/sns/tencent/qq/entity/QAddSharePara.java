package com.ubiyao.sns.tencent.qq.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.ubiyao.base.tencent.weibo.util.MapUtils;
import com.ubiyao.sns.tencent.weibo.util.TConstant;

/**    
 *         
 * Class Name：
 *			QAddSharePara    
 * Description：    
 *			发布、转发、评论微博时的对象
 * @Author	suhao
 * @Date	2014-1-17 下午1:52:08    
 * @Version	
 *     
 */
public class QAddSharePara implements Serializable {

	private static final long serialVersionUID = -177267939556171256L;

	private String title;// feeds的标题，对应上文接口说明中的2。 最长36个中文字，超出部分会被截断。
	private String url; // 分享所在网页资源的链接，点击后跳转至第三方网页，对应上文接口说明中2的超链接。
	private String comment; // 用户评论内容，也叫发表分享时的分享理由，对应上文接口说明的1。
	private String summary; // 所分享的网页资源的摘要内容，或者是网页的概要描述，对应上文接口说明的3。
	private String images; // 所分享的网页资源的代表性图片链接"，对应上文接口说明的4。
	private String format; // 定义API返回的数据格式。
	private String type; // 分享内容的类型。4表示网页；5表示视频（type=5时，必须传入playurl）。
	private String playurl; // 长度限制为256字节。仅在type=5的时候有效，表示视频的swf播放地址。
	private String site; // 分享的来源网站名称，请填写网站申请接入时注册的网站名称，对应上文接口说明的5。
	private String fromurl; // 分享的来源网站对应的网站地址url，对应上文接口说明中5的超链接。
	private String swb; // 值为1时，表示分享不默认同步到微博，其他值或者不传此参数表示默认同步到微博。

	/** 默认值 **/
	private static String defaultFormat = "";

	private static String defaultTitle = "";

	private static String defaultUrl = "";

	private static String defaultComment = "";

	private static String defaultSummary = "";

	private static String defaultImages = "";

	private static String defaultType = "";

	private static String defaultPlayurl = "";

	private static String defaultSite = "";

	private static String defaultFromurl = "";

	private static String defaultSwb = "0";

	public QAddSharePara() {
		super();

		format = defaultFormat;
		title = defaultTitle;
		url = defaultUrl;
		comment = defaultComment;
		summary = defaultSummary;
		images = defaultImages;
		type = defaultType;
		playurl = defaultPlayurl;
		site = defaultSite;
		fromurl = defaultFromurl;
		swb = defaultSwb;
	}

	/**
	 * 将微博对象转换为api需要的map
	 * 
	 * @return
	 */
	public Map<String, String> getParasMap() {
		Map<String, String> parasMap = new HashMap<String, String>();
		MapUtils.putMapNotEmptyKey(parasMap, TConstant.PARA_FORMAT, format);
		try {
			comment = URLEncoder.encode(comment, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MapUtils.putMapNotEmptyKey(parasMap, TConstant.PARA_VIDEO_URL, type);
		return parasMap;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlayurl() {
		return playurl;
	}

	public void setPlayurl(String playurl) {
		this.playurl = playurl;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getFromurl() {
		return fromurl;
	}

	public void setFromurl(String fromurl) {
		this.fromurl = fromurl;
	}

	public String getSwb() {
		return swb;
	}

	public void setSwb(String swb) {
		this.swb = swb;
	}

}
