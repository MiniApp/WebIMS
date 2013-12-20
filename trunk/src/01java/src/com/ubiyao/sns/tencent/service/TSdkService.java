package com.ubiyao.sns.tencent.service;

import java.util.List;
import java.util.Map;

import com.ubiyao.sns.tencent.entity.TAppAndToken;
import com.ubiyao.sns.tencent.entity.THotStatusPara;
import com.ubiyao.sns.tencent.entity.TResponse;
import com.ubiyao.sns.tencent.entity.TSearchPara;
import com.ubiyao.sns.tencent.entity.TStatus;
import com.ubiyao.sns.tencent.entity.TStatusInfoPara;
import com.ubiyao.sns.tencent.entity.TTimelinePara;
import com.ubiyao.sns.tencent.entity.TTopicSimple;
import com.ubiyao.sns.tencent.entity.TUpdateNumInfo;
import com.ubiyao.sns.tencent.entity.TUser;
import com.ubiyao.sns.tencent.entity.TUserEduPara;
import com.ubiyao.sns.tencent.entity.TUserPara;
import com.ubiyao.sns.tencent.entity.TUserRelation;
import com.ubiyao.sns.tencent.entity.TUserRelationPara;
import com.ubiyao.sns.tencent.entity.TVideoInfo;
import com.ubiyao.sns.tencent.util.TConstant;

public interface TSdkService {

    /**
     * 得到应用和用户相关信息
     * 
     * @return
     */
    public TAppAndToken getQqTAppAndToken();

    /**
     * 设置应用和用户相关信息
     * 
     * @param qqTAppAndToken
     */
    public void setQqTAppAndToken(TAppAndToken qqTAppAndToken);

    /**
     * 时间线通用api返回，字符串返回
     * <ul>
     * <li>{@link TTimelinePara#setFormat(String)}可取值有{@link TConstant#VALUE_FORMAT_JSON}以及
     * {@link TConstant#VALUE_FORMAT_XML}</li>
     * <li>{@link TTimelinePara#setStatusType(int)}可取值有{@link TConstant#VALUE_STATUS_TYPE_TL_ALL}，
     * {@link TConstant#VALUE_STATUS_TYPE_TL_COMMENT}以及QqTConstant中其他{@code VALUE_STATUS_TYPE_TL_×}，以及其|运算的到的数值</li>
     * <li>{@link TTimelinePara#setContentType(int)}可取值有{@link TConstant#VALUE_CONTENT_TYPE_TL_ALL}，
     * {@link TConstant#VALUE_CONTENT_TYPE_TL_MUSIC}以及QqTConstant中其他{@code VALUE_CONTENT_TYPE_TL_×}</li>
     * </ul>
     * 
     * @param url 请求的url
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public String getTimeLineCommonStr(String url, TTimelinePara qqTTimelinePara);

    /**
     * 时间线通用api返回，QqTStatus对象列表返回
     * 
     * @param url 请求的url
     * @param qqTTimelinePara 时间线参数
     * @param qq@return 以对象list的形式返回
     *            <ul>
     *            <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *            {@link TConstant#VALUE_FORMAT_JSON}</li>
     *            <li>调用{@link TSdkService#getTimeLineCommonStr(String, TTimelinePara)}后转换为对象</li>
     *            </ul>
     */
    public List<TStatus> getTimeLineCommon(String url, TTimelinePara qqTTimelinePara);

    /**
     * 时间线通用api返回，QqTResponse对象返回
     * 
     * @param url 请求的url
     * @param qqTTimelinePara 时间线参数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getTimeLineCommonStr(String, TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getTimeLineCommonRes(String url, TTimelinePara qqTTimelinePara);

    /**
     * 主页时间线，表示获取微博列表，可以通过对type，contenttype及其它设置获取不同的微博列表<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_14">腾讯微博<strong>主页时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getHomeTLStr(TTimelinePara qqTTimelinePara);

    /**
     * 主页时间线，表示获取微博列表，可以通过对type，contenttype及其它设置获取不同的微博列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getHomeTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getHomeTL(TTimelinePara qqTTimelinePara);

    /**
     * 主页时间线，返回QqTResponse，可以通过对type，contenttype及其它设置获取不同的微博列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getHomeTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getHomeTLRes(TTimelinePara qqTTimelinePara);

    /**
     * 广播大厅时间线，表示广播大厅中微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_15">腾讯微博<strong>广播大厅时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getPublicTLStr(TTimelinePara qqTTimelinePara);

    /**
     * 广播大厅时间线，表示广播大厅中微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getPublicTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getPublicTL(TTimelinePara qqTTimelinePara);

    /**
     * 广播大厅时间线，表示广播大厅中微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getPublicTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getPublicTLRes(TTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线，表示获取其他用户的微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_16">腾讯微博<strong>其他用户发表时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getUserTLStr(TTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线，表示获取其他用户的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUserTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getUserTL(TTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线，表示获取其他用户的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUserTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getUserTLRes(TTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线，表示获取提及到自己的微博，及@<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_17">腾讯微博<strong>用户提及时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getMentionsTLStr(TTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线，表示获取提及到自己的微博，及@
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getMentionsTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getMentionsTL(TTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线，表示获取提及到自己的微博，及@
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getMentionsTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getMentionsTLRes(TTimelinePara qqTTimelinePara);

    /**
     * 话题时间线，表示获取相关话题的微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_18">腾讯微博<strong>话题时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getTopicTLStr(TTimelinePara qqTTimelinePara);

    /**
     * 话题时间线，表示获取相关话题的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getTopicTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getTopicTL(TTimelinePara qqTTimelinePara);

    /**
     * 话题时间线，表示获取相关话题的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getTopicTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getTopicTLRes(TTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线，表示获取我发表的微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_19">腾讯微博<strong>我发表时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getBroadcastTLStr(TTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线，表示获取我发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getBroadcastTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getBroadcastTL(TTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线，表示获取我发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getBroadcastTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getBroadcastTLRes(TTimelinePara qqTTimelinePara);

    /**
     * 特别收听的人发表时间线，表示获取我特别接收的用户发表的微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_20">腾讯微博<strong>特别收听的人发表时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getSpecialTLStr(TTimelinePara qqTTimelinePara);

    /**
     * 特别收听的人发表时间线，表示获取我特别接收的用户发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getSpecialTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getSpecialTL(TTimelinePara qqTTimelinePara);

    /**
     * 特别收听的人发表时间线，表示获取我特别接收的用户发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getSpecialTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getSpecialTLRes(TTimelinePara qqTTimelinePara);

    /**
     * 地区发表时间线，表示获取某个地区发表的微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_72">腾讯微博<strong>地区发表时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getAreaTLStr(TTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线，表示获取我发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getAreaTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getAreaTL(TTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线，表示获取我发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getAreaTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getAreaTLRes(TTimelinePara qqTTimelinePara);

    /**
     * 主页时间线索引<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_77">腾讯微博<strong>主页时间线索引</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getHomeTLIdsStr(TTimelinePara qqTTimelinePara);

    /**
     * 主页时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getHomeTLIdsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getHomeTLIds(TTimelinePara qqTTimelinePara);

    /**
     * 主页时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getHomeTLIdsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getHomeTLIdsRes(TTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线索引<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_79">腾讯微博<strong>其他用户发表时间线索引</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getUserTLIdsStr(TTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUserTLIdsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getUserTLIds(TTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUserTLIdsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getUserTLIdsRes(TTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线索引<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_76">腾讯微博<strong>我发表时间线索引</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getBroadcastTLIdsStr(TTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getBroadcastTLIdsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getBroadcastTLIds(TTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getBroadcastTLIdsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getBroadcastTLIdsRes(TTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线索引<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_78">腾讯微博<strong>用户提及时间线索引</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getMentionsTLIdsStr(TTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getMentionsTLIdsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getMentionsTLIds(TTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getMentionsTLIdsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getMentionsTLIdsRes(TTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_73">腾讯微博<strong>多用户发表时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getUsersTLStr(TTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUsersTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getUsersTL(TTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUsersTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getUsersTLRes(TTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线索引<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_80">腾讯微博<strong>多用户发表时间线索引</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getUsersTLIdsStr(TTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUsersTLIdsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getUsersTLIds(TTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUsersTLIdsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getUsersTLIdsRes(TTimelinePara qqTTimelinePara);

    /**
     * 拉取vip用户发表微博消息<br/>
     * 具体参数见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E6%97%B6%E9%97%B4%E7%BA%BF/%E6%8B%89%E5%8F%96vip%E7%94%A8%E6%88%B7%E5%8F%91%E8%A1%A8%E5%BE%AE%E5%8D%9A%E6%B6%88%E6%81%AF%E6%8E%A5%E5%8F%A3"
     * >腾讯微博<strong>拉取vip用户发表微博消息</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getVipStatusTLStr(TTimelinePara qqTTimelinePara);

    /**
     * 拉取vip用户发表微博消息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getVipStatusTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getVipStatusTL(TTimelinePara qqTTimelinePara);

    /**
     * 拉取vip用户发表微博消息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getVipStatusTLStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getVipStatusTLRes(TTimelinePara qqTTimelinePara);

    /**
     * 得到某条微博的具体信息，字符串返回
     * 
     * @param format 返回信息格式
     * @param statusId 微博id
     * @return
     */
    public String getStatus(String format, long statusId);

    /**
     * 得到某条微博的具体信息，状态返回
     * 
     * @param statusId 微博id
     * @return
     */
    public TStatus getStatus(long statusId);

    /**
     * 得到某条微博的具体信息，QqTResponse返回
     * 
     * @param statusId 微博id
     * @return
     */
    public TResponse getStatusRes(long statusId);

    /**
     * 新增状态通用api，返回字符串
     * 
     * @param addStatusUrl 新增状态的url
     * @param status 状态内容
     * @return
     */
    public String addStatusCommonStr(String addStatusUrl, TStatusInfoPara status);

    /**
     * 新增状态通用api，返回是否新增成功
     * 
     * @param addStatusUrl 新增状态的url
     * @param status 状态内容
     * @return
     */
    public boolean addStatusCommon(String addStatusUrl, TStatusInfoPara status);

    /**
     * 新增状态通用api，返回QqTResponse
     * 
     * @param addStatusUrl 新增状态的url
     * @param status 状态内容
     * @return
     */
    public TResponse addStatusCommonRes(String addStatusUrl, TStatusInfoPara status);

    /**
     * 发布一条微博，返回字符串
     * 
     * @param status 微博内容信息
     * @return
     */
    public String addStatusStr(TStatusInfoPara status);

    /**
     * 发布一条微博，返回是否成功
     * 
     * @param status 微博内容信息
     * @return
     */
    public boolean addStatus(TStatusInfoPara status);

    /**
     * 发布一条微博，返回QqTResponse
     * 
     * @param status 微博内容信息
     * @return
     */
    public TResponse addStatusRes(TStatusInfoPara status);

    /**
     * 发布一条简单微博，返回字符串
     * 
     * @param content 微博内容信息
     * @param imagePath 图片路径，若无图片，传null
     * @return
     */
    public String addStatusStr(String content, String imagePath);

    /**
     * 发布一条简单微博，返回是否成功
     * 
     * @param content 微博内容信息
     * @param imagePath 图片路径，若无图片，传null
     * @return
     */
    public boolean addStatus(String content, String imagePath);

    /**
     * 发布一条简单微博，返回QqTResponse
     * 
     * @param content 微博内容信息
     * @param imagePath 图片路径，若无图片，传null
     * @return
     */
    public TResponse addStatusRes(String content, String imagePath);

    /**
     * 转发一条微博，根据format返回字符串
     * 
     * @param status 微博内容
     * @return
     */
    public String repostStr(TStatusInfoPara status);

    /**
     * 转发一条微博，返回是否成功
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return
     */
    public boolean repost(TStatusInfoPara status);

    /**
     * 转发一条微博，返回QqTResponse
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return 返回QqTResponse
     */
    public TResponse repostRes(TStatusInfoPara status);

    /**
     * 回复一条微博，根据format返回字符串
     * 
     * @param status 微博内容
     * @return
     */
    public String replyStr(TStatusInfoPara status);

    /**
     * 回复一条微博，返回是否成功
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return 是否成功回复
     */
    public boolean reply(TStatusInfoPara status);

    /**
     * 回复一条微博，返回QqTResponse
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return 返回QqTResponse
     */
    public TResponse replyRes(TStatusInfoPara status);

    /**
     * 评论一条微博，根据format返回字符串
     * 
     * @param status 微博内容
     * @return
     */
    public String commentStr(TStatusInfoPara status);

    /**
     * 评论一条微博，返回是否成功
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return 是否成功评论
     */
    public boolean comment(TStatusInfoPara status);

    /**
     * 评论一条微博，返回QqTResponse
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return 返回QqTResponse
     */
    public TResponse commentRes(TStatusInfoPara status);

    /**
     * 发表音乐微博，根据format返回字符串
     * 
     * @param status 微博内容
     * @return
     */
    public String addMusicStatusStr(TStatusInfoPara status);

    /**
     * 发表音乐微博，返回是否发表成功
     * 
     * @param status 微博内容
     * @return 返回是否发表成功
     */
    public boolean addMusicStatus(TStatusInfoPara status);

    /**
     * 发表音乐微博，返回QqTResponse
     * 
     * @param status 微博内容
     * @return 返回QqTResponse
     */
    public TResponse addMusicStatusRes(TStatusInfoPara status);

    /**
     * 发表视频微博，根据format返回字符串
     * 
     * @param status 微博内容
     * @return
     */
    public String addVideoStatusStr(TStatusInfoPara status);

    /**
     * 发表视频微博，返回是否发表成功
     * 
     * @param status 微博内容
     * @return 返回是否发表成功
     */
    public boolean addVideoStatus(TStatusInfoPara status);

    /**
     * 发表视频微博，返回QqTResponse
     * 
     * @param status 微博内容
     * @return 返回QqTResponse
     */
    public TResponse addVideoStatusRes(TStatusInfoPara status);

    /**
     * 获得某条微博的评论或转发信息通用api，String返回
     * 
     * @param repostOrCommentFlag 点评还是转播标识
     * @param qqTTimelinePara 时间线参数
     * @return
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara<br/>
     *         设置{@link TTimelinePara#setRepostOrCommentFlag(int)}为 repostOrCommentFlag</li>
     *         <li>调用 {@link TSdkService#getTimeLineCommonStr(String, TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public String getStatusCommentsCommonStr(int repostOrCommentFlag, TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论或转发信息通用api，QqTStatus list返回
     * 
     * @param repostOrCommentFlag 点评还是转播标识
     * @param qqTTimelinePara 时间线参数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara<br/>
     *         设置{@link TTimelinePara#setFormat(String)}为 {@link TConstant#VALUE_FORMAT_JSON}<br/>
     *         设置{@link TTimelinePara#setRepostOrCommentFlag(int)}为 repostOrCommentFlag</li>
     *         <li>调用 {@link TSdkService#getTimeLineCommon(String, TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getStatusCommentsCommon(int repostOrCommentFlag, TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论或转发信息通用api，QqTResponse返回
     * 
     * @param repostOrCommentFlag 点评还是转播标识
     * @param qqTTimelinePara 时间线参数
     * @return 以QqTResponse对象形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara<br/>
     *         设置{@link TTimelinePara#setFormat(String)}为 {@link TConstant#VALUE_FORMAT_JSON}<br/>
     *         设置{@link TTimelinePara#setRepostOrCommentFlag(int)}为 repostOrCommentFlag</li>
     *         <li>调用 {@link TSdkService#getTimeLineCommonRes(String, TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getStatusCommentsCommonRes(int repostOrCommentFlag, TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论信息，返回字符串
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public String getStatusCommentsStr(TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论信息，返回状态list
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public List<TStatus> getStatusComments(TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论信息，返回QqTResponse
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public TResponse getStatusCommentsRes(TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的转发信息，返回字符串
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public String getStatusRepostsStr(TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的转发信息，返回状态list
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public List<TStatus> getStatusReposts(TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的转发信息，返回QqTResponse
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public TResponse getStatusRepostsRes(TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论和转发信息，返回字符串
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public String getStatusCommentsAndRepostsStr(TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论和转发信息，返回状态list
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public List<TStatus> getStatusCommentsAndReposts(TTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论和转发信息，返回QqTResponse
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public TResponse getStatusCommentsAndRepostsRes(TTimelinePara qqTTimelinePara);

    /**
     * 获取视频信息，以字符串形式返回
     * 
     * @param format 返回的数据格式
     * @param videoUrl 视频url
     * @return
     */
    public String getVideoInfo(String format, String videoUrl);

    /**
     * 获取视频信息，以QqTVideoInfo对象形式返回
     * 
     * @param videoUrl 视频url
     * @return
     */
    public TVideoInfo getVideoInfo(String videoUrl);

    /**
     * 获取视频信息，以QqTResponse对象形式返回
     * 
     * @param videoUrl 视频url
     * @return
     */
    public TResponse getVideoInfoRes(String videoUrl);

    /**
     * 根据微博id批量获取微博内容，返回字符串
     * 
     * @param format 返回数据格式
     * @param ids 微博id，以逗号分隔
     * @return
     */
    public String getStatusByIdsStr(String format, String ids);

    /**
     * 根据微博id批量获取微博内容
     * 
     * @param ids 微博id，以逗号分隔
     * @return
     */
    public List<TStatus> getStatusByIds(String ids);

    /**
     * 根据微博id批量获取微博内容，返回QqTResponse
     * 
     * @param ids 微博id，以逗号分隔
     * @return
     */
    public TResponse getStatusByIdsRes(String ids);

    /**
     * 根据微博id批量获取转播的再次转播数，返回字符串
     * 
     * @param format 返回数据格式
     * @param ids 微博id，以逗号分隔
     * @return
     */
    public String getReRepostCountByIdsStr(String format, String ids);

    /**
     * 根据微博id批量获取转播的再次转播数
     * 
     * @param ids 微博id，以逗号分隔
     * @return key为微博id，value为再次转播数
     */
    public Map<Long, Integer> getReRepostCountByIds(String ids);

    /**
     * 根据微博id批量获取转播的再次转播数，返回QqTResponse
     * 
     * @param ids 微博id，以逗号分隔
     * @return key为微博id，value为再次转播数
     */
    public TResponse getReRepostCountByIdsRes(String ids);

    /**
     * 发表心情帖子，返回字符串
     * 
     * @param status 心情帖子信息
     * @return
     */
    public String addEmotionStr(TStatusInfoPara status);

    /**
     * 发表心情帖子，返回是否成功
     * 
     * @param status 心情帖子信息
     * @return
     */
    public boolean addEmotion(TStatusInfoPara status);

    /**
     * 发表心情帖子，返回QqTResponse
     * 
     * @param status 心情帖子信息
     * @return
     */
    public TResponse addEmotionRes(TStatusInfoPara status);

    /**
     * 操作单条状态（类似收藏、删除）通用api，返回字符串
     * 
     * @param url 操作的url
     * @param format 返回数据格式
     * @param statusId 微博id
     * @return
     */
    public String operateStatusCommonStr(String url, String format, long statusId);

    /**
     * 操作单条状态通用api，返回是否操作成功
     * 
     * @param url 操作的url
     * @param statusId 微博id
     * @return
     */
    public boolean operateStatusCommon(String url, long statusId);

    /**
     * 操作单条状态通用api，返回QqTResponse
     * 
     * @param url 操作的url
     * @param statusId 微博id
     * @return
     */
    public TResponse operateStatusCommonRes(String url, long statusId);

    /**
     * 删除一条微博
     * 
     * @param statusId 微博id
     * @return 是否成功删除
     */
    public boolean delete(long statusId);

    /**
     * 删除一条微博，返回QqTResponse
     * 
     * @param statusId 微博id
     * @return
     */
    public TResponse deleteRes(long statusId);

    /**
     * 转播数或点评数，返回字符串
     * 
     * @param format 返回信息格式
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记
     * @return
     */
    public String getRepostAndCommentCount(String format, String statusIds, int flag);

    /**
     * 转播数或点评数
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记 {@link TConstant#VALUE_RE_COUNT_FLAG_ALL}表示转播数和点评数，
     *            {@link TConstant#VALUE_RE_COUNT_FLAG_REPOST}表示转播数， {@link TConstant#VALUE_RE_COUNT_FLAG_COMMENT}
     *            表示点评数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>调用{@link TSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>返回的对象只包含statusId以及commentCount、repostCount之一或全部，根据flag设置</li>
     *         </ul>
     */
    public List<TStatus> getRepostAndCommentCount(String statusIds, int flag);

    /**
     * 转播数或点评数，以QqTResponse返回
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记 {@link TConstant#VALUE_RE_COUNT_FLAG_ALL}表示转播数和点评数，
     *            {@link TConstant#VALUE_RE_COUNT_FLAG_REPOST}表示转播数， {@link TConstant#VALUE_RE_COUNT_FLAG_COMMENT}
     *            表示点评数
     * @return 以QqTResponse的形式返回
     *         <ul>
     *         <li>调用{@link TSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>返回的对象只包含statusId以及commentCount、repostCount之一或全部，根据flag设置</li>
     *         </ul>
     */
    public TResponse getRepostAndCommentCountRes(String statusIds, int flag);

    /**
     * 转播数和点评数
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>调用{@link TSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>返回的对象只包含statusId、commentCount和repostCount</li>
     *         </ul>
     */
    public List<TStatus> getRepostAndCommentCount(String statusIds);

    /**
     * 转播数和点评数，以QqTResponse返回
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>调用{@link TSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>返回的对象只包含statusId、commentCount和repostCount</li>
     *         </ul>
     */
    public TResponse getRepostAndCommentCountRes(String statusIds);

    /**
     * 转播数或点评数
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记
     * @return 以map的形式返回, key为状态id，name为点评数或转播数
     *         <ul>
     *         <li>调用{@link TSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>解析字符串得到id和点评数或转播数信息</li>
     *         </ul>
     */
    public Map<Long, Integer> getRepostOrCommentCount(String statusIds, int flag);

    /**
     * 转播数或点评数，以QqTResponse返回
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记
     * @return 以map的形式返回, key为状态id，name为点评数或转播数
     *         <ul>
     *         <li>调用{@link TSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>解析字符串得到id和点评数或转播数信息</li>
     *         </ul>
     */
    public TResponse getRepostOrCommentCountRes(String statusIds, int flag);

    /**
     * 获取自己的详细资料
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E8%8E%B7%E5%8F%96%E8%87%AA%E5%B7%B1%E7%9A%84%E8%AF%A6%E7%BB%86%E8%B5%84%E6%96%99"
     * >腾讯微博<strong>获取自己的详细资料</strong>api</a>
     * 
     * @param format 返回信息格式
     * @return
     */
    public String getSelfInfo(String format);

    /**
     * 获取自己的详细资料，转换为QqTUser
     * 
     * @return
     */
    public TUser getSelfInfo();

    /**
     * 获取自己的详细资料，转换为QqTResponse
     * 
     * @return
     */
    public TResponse getSelfInfoRes();

    /**
     * 更新用户信息，返回字符串
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E6%9B%B4%E6%96%B0%E7%94%A8%E6%88%B7%E4%BF%A1%E6%81%AF"
     * >腾讯微博<strong>更新用户信息</strong>api</a>
     * 
     * @param qqTUserPara 用户信息
     * @return
     */
    public String updateSelfInfoStr(TUserPara qqTUserPara);

    /**
     * 更新用户信息
     * 
     * @param qqTUserPara 用户信息
     * @return
     */
    public boolean updateSelfInfo(TUserPara qqTUserPara);

    /**
     * 更新用户信息，返回QqTResponse
     * 
     * @param qqTUserPara 用户信息
     * @return
     */
    public TResponse updateSelfInfoRes(TUserPara qqTUserPara);

    /**
     * 更新用户头像信息，返回字符串
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E6%9B%B4%E6%96%B0%E7%94%A8%E6%88%B7%E5%A4%B4%E5%83%8F%E4%BF%A1%E6%81%AF"
     * >腾讯微博<strong>更新用户头像信息</strong>api</a>
     * 
     * @param format 返回数据格式
     * @param headImagePath 头像图片路径
     * @return
     */
    public String updateSelfHeadStr(String format, String headImagePath);

    /**
     * 更新用户头像信息，返回是否操作成功
     * 
     * @param headImagePath 头像图片路径
     * @return
     */
    public boolean updateSelfHead(String headImagePath);

    /**
     * 更新用户头像信息，返回QqTResponse
     * 
     * @param headImagePath 头像图片路径
     * @return
     */
    public TResponse updateSelfHeadRes(String headImagePath);

    /**
     * 更新用户教育信息，返回字符串
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E6%9B%B4%E6%96%B0%E7%94%A8%E6%88%B7%E6%95%99%E8%82%B2%E4%BF%A1%E6%81%AF"
     * >腾讯微博<strong>更新用户教育信息</strong>api</a>
     * <ul>
     * <li>添加教育信息, {@link TUserEduPara#setFeildId(long)} feildId=1</li>
     * <li>修改教育信息，{@link TUserEduPara#setFeildId(long)} 填返回的feildId</li>
     * <li>删除教育信息，{@link TUserEduPara#setFeildId(long)} 填返回的feildId，其余参数除format外为空</li>
     * </ul>
     * 
     * @param qqTUserEduPara 用户教育信息
     * @return
     */
    public String updateSelfEduInfoStr(TUserEduPara qqTUserEduPara);

    /**
     * 更新用户教育信息
     * <ul>
     * <li>添加教育信息, {@link TUserEduPara#setFeildId(long)} feildId=1</li>
     * <li>修改教育信息，{@link TUserEduPara#setFeildId(long)} 填返回的feildId</li>
     * <li>删除教育信息，{@link TUserEduPara#setFeildId(long)} 填返回的feildId，其余参数除format外为空</li>
     * </ul>
     * 
     * @param qqTUserEduPara 用户教育信息
     * @return
     */
    public boolean updateSelfEduInfo(TUserEduPara qqTUserEduPara);

    /**
     * 更新用户教育信息，返回QqTResponse
     * <ul>
     * <li>添加教育信息, {@link TUserEduPara#setFeildId(long)} feildId=1</li>
     * <li>修改教育信息，{@link TUserEduPara#setFeildId(long)} 填返回的feildId</li>
     * <li>删除教育信息，{@link TUserEduPara#setFeildId(long)} 填返回的feildId，其余参数除format外为空</li>
     * </ul>
     * 
     * @param qqTUserEduPara 用户教育信息
     * @return
     */
    public TResponse updateSelfEduInfoRes(TUserEduPara qqTUserEduPara);

    /**
     * 获取其他人资料
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E8%8E%B7%E5%8F%96%E5%85%B6%E4%BB%96%E4%BA%BA%E8%B5%84%E6%96%99"
     * >腾讯微博<strong>获取其他人资料</strong>api</a>
     * <ul>
     * <li>只需根据userName获取信息，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId获取信息，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回信息格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String getOtherUserInfo(String format, String userName, String userOpenId);

    /**
     * 获取其他人资料，转换为QqTUser
     * <ul>
     * <li>只需根据userName获取信息，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId获取信息，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public TUser getOtherUserInfo(String userName, String userOpenId);

    /**
     * 获取其他人资料，转换为QqTResponse
     * <ul>
     * <li>只需根据userName获取信息，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId获取信息，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public TResponse getOtherUserInfoRes(String userName, String userOpenId);

    /**
     * 获取一批人的简单资料
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E8%8E%B7%E5%8F%96%E4%B8%80%E6%89%B9%E4%BA%BA%E7%9A%84%E7%AE%80%E5%8D%95%E8%B5%84%E6%96%99"
     * >腾讯微博<strong>获取一批人的简单资料</strong>api</a>
     * <ul>
     * <li>只需根据userNames获取信息，则userOpenIds传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenIds获取信息，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param format 返回信息格式
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public String getOtherUsersInfo(String format, String userNames, String userOpenIds);

    /**
     * 获取一批人的简单资料，转换为QqTUser list
     * <ul>
     * <li>只需根据userNames获取信息，则userOpenIds传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenIds获取信息，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public List<TUser> getOtherUsersInfo(String userNames, String userOpenIds);

    /**
     * 获取一批人的简单资料，转换为QqTResponse
     * <ul>
     * <li>只需根据userNames获取信息，则userOpenIds传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenIds获取信息，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public TResponse getOtherUsersInfoRes(String userNames, String userOpenIds);

    /**
     * 验证账户是否合法，返回字符串
     * <ul>
     * <li>只需按照userName验证，则userId传入{@code null}或者空字符串</li>
     * <li>只需按照userId验证，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E9%AA%8C%E8%AF%81%E8%B4%A6%E6%88%B7%E6%98%AF%E5%90%A6%E5%90%88%E6%B3%95"
     * >腾讯微博<strong>验证账户是否合法</strong>api</a>
     * 
     * @param format 返回的数据格式
     * @param userName 用户名
     * @param userId 用户Id
     * @return
     */
    public String verifyAccountStr(String format, String userName, String userId);

    /**
     * 验证账户是否合法
     * 
     * @param userName 用户名
     * @param userId 用户Id
     * @return
     *         <ul>
     *         <li>调用{@link TSdkService#verifyAccountStr(String, String, String)}后进行判断</li>
     *         <li>当发送的请求返回错误或是用户不存在皆会返回false</li>
     *         <li>用户存在返回true</li>
     *         </ul>
     */
    public boolean verifyAccount(String userName, String userId);

    /**
     * 验证账户是否合法，返回QqTResponse
     * 
     * @param userName 用户名
     * @param userId 用户Id
     * @return
     *         <ul>
     *         <li>调用{@link TSdkService#verifyAccountStr(String, String, String)}</li>
     *         </ul>
     */
    public TResponse verifyAccountRes(String userName, String userId);

    /**
     * 得到和某人有关系的用户信息通用api，返回字符串
     * 
     * @param url 获取关系的url
     * @param qqTUserRelationPara 获取关系的参数
     * @return
     */
    public String getUserRelationsCommonStr(String url, TUserRelationPara qqTUserRelationPara);

    /**
     * 得到和某人有关系的用户信息通用api，返回QqTUser list
     * 
     * @param url 获取关系的url
     * @param qqTUserRelationPara 获取关系的参数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变QqTUserRelationPara，设置{@link TUserRelationPara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUserRelationsCommonStr(String, TUserRelationPara)}后转换为对象</li>
     *         </ul>
     */
    public List<TUser> getUserRelationsCommon(String url, TUserRelationPara qqTUserRelationPara);

    /**
     * 得到和某人有关系的用户信息通用api，返回QqTResponse
     * 
     * @param url 获取关系的url
     * @param qqTUserRelationPara 获取关系的参数
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变QqTUserRelationPara，设置{@link TUserRelationPara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUserRelationsCommonStr(String, TUserRelationPara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getUserRelationsCommonRes(String url, TUserRelationPara qqTUserRelationPara);

    /**
     * 得到和某人有关系的用户姓名信息通用api，返回String list
     * 
     * @param url 获取关系的url
     * @param qqTUserRelationPara 获取关系的参数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变QqTUserRelationPara，设置{@link TUserRelationPara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUserRelationsCommonStr(String, TUserRelationPara)} 后转换为String List</li>
     *         </ul>
     */
    public List<String> getUserRelationsNameCommon(String url, TUserRelationPara qqTUserRelationPara);

    /**
     * 得到和某人有关系的用户姓名信息通用api，返回QqTResponse
     * 
     * @param url 获取关系的url
     * @param qqTUserRelationPara 获取关系的参数
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变QqTUserRelationPara，设置{@link TUserRelationPara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getUserRelationsCommonStr(String, TUserRelationPara)} 后转换为String List</li>
     *         </ul>
     */
    public TResponse getUserRelationsNameCommonRes(String url, TUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfFansStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<TUser> getSelfFans(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getSelfFansStrRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfFansStr(String format, int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户信息，以对象list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<TUser> getSelfFans(int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getSelfFansRes(int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户姓名信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfFansNamesStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户姓名信息，以String list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<String> getSelfFansNames(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户姓名信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getSelfFansNamesRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户姓名信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfFansNamesStr(String format, int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户姓名信息，以String list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<String> getSelfFansNames(int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户姓名信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getSelfFansNamesRes(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfInterestedStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<TUser> getSelfInterested(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getSelfInterestedRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfInterestedStr(String format, int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户信息，以对象list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<TUser> getSelfInterested(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getSelfInterestedRes(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户姓名信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfInterestedNamesStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户姓名信息，以String list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<String> getSelfInterestedNames(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户姓名信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getSelfInterestedNamesRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户姓名信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfInterestedNamesStr(String format, int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户姓名信息，以String list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<String> getSelfInterestedNames(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户姓名信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getSelfInterestedNamesRes(int reqNumber, int startIndex);

    /**
     * 得到自己黑名单中的用户信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfBlackListStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己黑名单中的用户信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<TUser> getSelfBlackList(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己黑名单中的用户信息，以QqTResponse形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getSelfBlackListRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己黑名单中的用户信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfBlackListStr(String format, int reqNumber, int startIndex);

    /**
     * 得到自己黑名单中的用户信息，以对象list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<TUser> getSelfBlackList(int reqNumber, int startIndex);

    /**
     * 得到自己黑名单中的用户信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getSelfBlackListRes(int reqNumber, int startIndex);

    /**
     * 得到自己特别关注的用户信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfSpecialInterestedStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己特别关注的用户信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<TUser> getSelfSpecialInterested(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己特别关注的用户信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getSelfSpecialInterestedRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己特别关注的用户信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfSpecialInterestedStr(String format, int reqNumber, int startIndex);

    /**
     * 得到自己特别关注的用户信息，以对象list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<TUser> getSelfSpecialInterested(int reqNumber, int startIndex);

    /**
     * 得到自己特别关注的用户信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getSelfSpecialInterestedRes(int reqNumber, int startIndex);

    /**
     * 得到其他用户的粉丝信息，以字符串形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getOtherUserFansStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户的粉丝信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<TUser> getOtherUserFans(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户的粉丝信息，以QqTResponse对象返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getOtherUserFansRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户的粉丝信息，以字符串形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回信息格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getOtherUserFansStr(String format, String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户的粉丝信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<TUser> getOtherUserFans(String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户的粉丝信息，以QqTResponse对象返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getOtherUserFansRes(String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户关注的用户信息，以字符串形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getOtherUserInterestedStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户关注的用户信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<TUser> getOtherUserInterested(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户关注的用户信息，以QqTResponse对象形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getOtherUserInterestedRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户关注的用户信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getOtherUserInterestedStr(String format, String userName, String userOpenId, int reqNumber,
                                            int startIndex);

    /**
     * 得到其他用户关注的用户信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<TUser> getOtherUserInterested(String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户关注的用户信息，以QqTResponse对象形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getOtherUserInterestedRes(String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户特别关注的用户信息，以字符串形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getOtherUserSpecialInterestedStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户特别关注的用户信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<TUser> getOtherUserSpecialInterested(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户特别关注的用户信息，以QqTResponse对象形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getOtherUserSpecialInterestedRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户特别关注的用户信息，以字符串形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回信息格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getOtherUserSpecialInterestedStr(String format, String userName, String userOpenId, int reqNumber,
                                                   int startIndex);

    /**
     * 得到其他用户特别关注的用户信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<TUser> getOtherUserSpecialInterested(String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户特别关注的用户信息，以QqTResponse对象形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getOtherUserSpecialInterestedRes(String userName, String userOpenId, int reqNumber,
                                                        int startIndex);

    /**
     * 得到关注自己的用户的简单信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfFansSimpleInfoStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户的简单信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<TUser> getSelfFansSimpleInfo(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户的简单信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getSelfFansSimpleInfoRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户的简单信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfFansSimpleInfoStr(String format, int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户的简单信息，以对象list形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<TUser> getSelfFansSimpleInfo(int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户的简单信息，以QqTResponse对象形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getSelfFansSimpleInfoRes(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户的简单信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfInterestedSimpleInfoStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户的简单信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<TUser> getSelfInterestedSimpleInfo(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户的简单信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getSelfInterestedSimpleInfoRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户的简单信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfInterestedSimpleInfoStr(String format, int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户的简单信息，以对象list形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<TUser> getSelfInterestedSimpleInfo(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户的简单信息，以QqTResponse对象形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getSelfInterestedSimpleInfoRes(int reqNumber, int startIndex);

    /**
     * 得到互听关系链列表，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getMutualInterestedStr(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到互听关系链列表，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<TUser> getMutualInterested(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到互听关系链列表，以QqTResponse对象返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public TResponse getMutualInterestedRes(TUserRelationPara qqTUserRelationPara);

    /**
     * 得到互听关系链列表，以字符串形式返回
     * 
     * @param userName 用户名
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getMutualInterestedStr(String format, String userName, int reqNumber, int startIndex);

    /**
     * 得到互听关系链列表，以对象list形式返回
     * 
     * @param userName 用户名
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<TUser> getMutualInterested(int reqNumber, String userName, int startIndex);

    /**
     * 得到互听关系链列表，以QqTResponse对象返回
     * 
     * @param userName 用户名
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public TResponse getMutualInterestedRes(int reqNumber, String userName, int startIndex);

    /**
     * 和某人建立或取消某种关系通用api，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回信息格式
     * @param url 操作关系的url
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String relationWithOtherCommonStr(String format, String url, String userName, String userOpenId);

    /**
     * 和某人建立或取消某种关系通用api，返回是否操作成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param url 操作关系的url
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return 是否操作成功
     *         <ul>
     *         <li>调用{@link TSdkService#relationWithOtherCommonStr(String, String, String, String)}</li>
     *         </ul>
     */
    public boolean relationWithOtherCommon(String url, String userName, String userOpenId);

    /**
     * 和某人建立或取消某种关系通用api，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param url 操作关系的url
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return 是否操作成功
     *         <ul>
     *         <li>调用{@link TSdkService#relationWithOtherCommonStr(String, String, String, String)}</li>
     *         </ul>
     */
    public TResponse relationWithOtherCommonRes(String url, String userName, String userOpenId);

    /**
     * 收听(关注)某人，返回字符串
     * <ul>
     * <li>只需根据userNames建立关系，则userOpenIds传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenIds建立关系，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public String interestedInOther(String format, String userNames, String userOpenIds);

    /**
     * 收听(关注)某人，返回操作是否成功
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userOpenIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public boolean interestedInOther(String userNames, String userOpenIds);

    /**
     * 收听(关注)某人，返回QqTResponse
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userOpenIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public TResponse interestedInOtherRes(String userNames, String userOpenIds);

    /**
     * 取消收听(关注)某人，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String cancelInterestedInOther(String format, String userName, String userOpenId);

    /**
     * 取消收听(关注)某人，返回操作是否成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public boolean cancelInterestedInOther(String userName, String userOpenId);

    /**
     * 取消收听(关注)某人，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public TResponse cancelInterestedInOtherRes(String userName, String userOpenId);

    /**
     * 特别收听(关注)某人，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String specialInterestedInOther(String format, String userName, String userOpenId);

    /**
     * 特别收听(关注)某人，返回操作是否成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public boolean specialInterestedInOther(String userName, String userOpenId);

    /**
     * 特别收听(关注)某人，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public TResponse specialInterestedInOtherRes(String userName, String userOpenId);

    /**
     * 取消特别收听(关注)某人，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String cancelSpecialInterestedInOther(String format, String userName, String userOpenId);

    /**
     * 取消特别收听(关注)某人，返回操作是否成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public boolean cancelSpecialInterestedInOther(String userName, String userOpenId);

    /**
     * 取消特别收听(关注)某人，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public TResponse cancelSpecialInterestedInOtherRes(String userName, String userOpenId);

    /**
     * 添加某个用户到黑名单，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String addOtherToBlackList(String format, String userName, String userOpenId);

    /**
     * 添加某个用户到黑名单，返回操作是否成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public boolean addOtherToBlackList(String userName, String userOpenId);

    /**
     * 添加某个用户到黑名单，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public TResponse addOtherToBlackListRes(String userName, String userOpenId);

    /**
     * 从黑名单中删除某个用户，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String deleteFromBlackList(String format, String userName, String userOpenId);

    /**
     * 从黑名单中删除某个用户，返回操作是否成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public boolean deleteFromBlackList(String userName, String userOpenId);

    /**
     * 从黑名单中删除某个用户，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public TResponse deleteFromBlackListRes(String userName, String userOpenId);

    /**
     * 检测是否我的听众或收听的人，返回字符串
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @param flag 关系标记
     * @return
     */
    public String checkRelationWithSelf(String format, String userNames, String userOpenIds, int flag);

    /**
     * 检测是否我的听众或收听的人，返回用户和自己的关系
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public List<TUserRelation> getIsFanAndInterested(String userNames, String userOpenIds);

    /**
     * 检测是否我的听众或收听的人，返回QqTResponse
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public TResponse getIsFanAndInterestedRes(String userNames, String userOpenIds);

    /**
     * 检测是否我的听众或收听的人，返回map，key为用户名，value为true或false，表示是否是听众或收听的人
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public Map<String, Boolean> getIsFanOrInterested(String userNames, String userOpenIds, int flag);

    /**
     * 检测是否我的听众或收听的人，返回QqTResponse
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public TResponse getIsFanOrInterestedRes(String userNames, String userOpenIds, int flag);

    /**
     * 发私信，根据format返回字符串
     * 
     * @param message 私信内容
     * @return
     */
    public String sendMessageStr(TStatusInfoPara message);

    /**
     * 发私信，返回是否发表成功
     * 
     * @param message 私信内容
     * @return 返回是否发表成功
     *         <ul>
     *         <li>此函数会改变message，设置{@link TStatusInfoPara#setFormat(String)}为 {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#sendMessageStr(TStatusInfoPara)}后转换为对象</li>
     *         </ul>
     */
    public boolean sendMessage(TStatusInfoPara message);

    /**
     * 发私信，返回QqTResponse
     * 
     * @param message 私信内容
     * @return 返回QqTResponse
     *         <ul>
     *         <li>此函数会改变message，设置{@link TStatusInfoPara#setFormat(String)}为 {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#sendMessageStr(TStatusInfoPara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse sendMessageRes(TStatusInfoPara message);

    /**
     * 删除一条私信
     * 
     * @param messageId 私信id
     * @return 是否成功评论
     */
    public boolean deleteMessage(long messageId);

    /**
     * 删除一条私信，返回QqTResponse
     * 
     * @param messageId 私信id
     * @return
     */
    public TResponse deleteMessageRes(long messageId);

    /**
     * 收件箱，表示收到的私信列表
     * 具体参数见<a
     * href="http://wiki.open.t.qq.com/index.php/%E7%A7%81%E4%BF%A1%E7%9B%B8%E5%85%B3/%E6%94%B6%E4%BB%B6%E7%AE%B1"
     * >腾讯微博<strong>私信收件箱</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getReceiveMessagesStr(TTimelinePara qqTTimelinePara);

    /**
     * 收件箱，表示收到的私信列表
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getReceiveMessagesStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getReceiveMessages(TTimelinePara qqTTimelinePara);

    /**
     * 收件箱，表示收到的私信列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getReceiveMessagesStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getReceiveMessagesRes(TTimelinePara qqTTimelinePara);

    /**
     * 发件箱，表示发出的私信列表<br/>
     * 具体参数见<a
     * href="http://wiki.open.t.qq.com/index.php/%E7%A7%81%E4%BF%A1%E7%9B%B8%E5%85%B3/%E5%8F%91%E4%BB%B6%E7%AE%B1"
     * >腾讯微博<strong>私信发件箱</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getSendMessagesStr(TTimelinePara qqTTimelinePara);

    /**
     * 发件箱，表示发出的私信列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getSendMessagesStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getSendMessages(TTimelinePara qqTTimelinePara);

    /**
     * 发件箱，表示发出的私信列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getSendMessagesStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getSendMessagesRes(TTimelinePara qqTTimelinePara);

    /**
     * 搜索通用api，返回字符串
     * 
     * @param url 搜索url
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public String searchCommonStr(String url, TSearchPara qqTSearchPara);

    /**
     * 搜索用户通用api，返回用户列表
     * 
     * @param url 搜索url
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public List<TUser> searchUserCommon(String url, TSearchPara qqTSearchPara);

    /**
     * 搜索用户通用api，返回QqTResponse
     * 
     * @param url 搜索url
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public TResponse searchUserCommonRes(String url, TSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索用户api，返回字符串
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public String searchUserStr(TSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索用户api，返回用户列表
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public List<TUser> searchUser(TSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索用户api，返回QqTResponse
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public TResponse searchUserRes(TSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索微博api，返回字符串
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public String searchStatusStr(TSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索微博api，返回微博列表
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public List<TStatus> searchStatus(TSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索微博api，返回QqTResponse
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public TResponse searchStatusRes(TSearchPara qqTSearchPara);

    /**
     * 根据标签搜索用户api，返回字符串
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public String searchUserByTagStr(TSearchPara qqTSearchPara);

    /**
     * 根据标签搜索用户api，返回用户列表
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public List<TUser> searchUserByTag(TSearchPara qqTSearchPara);

    /**
     * 根据标签搜索用户api，返回QqTResponse
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public TResponse searchUserByTagRes(TSearchPara qqTSearchPara);

    /**
     * 热榜通用api，返回字符串
     * 
     * @param url 链接地址
     * @param qqTHotStatusPara 参数
     * @return
     */
    public String getHotCommonStr(String url, THotStatusPara qqTHotStatusPara);

    /**
     * 话题热榜，返回字符串
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public String getHotTopicsStr(THotStatusPara qqTHotStatusPara);

    /**
     * 话题热榜，返回QqTTopicSimple list
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public List<TTopicSimple> getHotTopics(THotStatusPara qqTHotStatusPara);

    /**
     * 话题热榜，返回QqTResponse
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public TResponse getHotTopicsRes(THotStatusPara qqTHotStatusPara);

    /**
     * 转播热榜，返回字符串
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public String getHotRepostsStr(THotStatusPara qqTHotStatusPara);

    /**
     * 转播热榜，返回QqTStatus List
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public List<TStatus> getHotReposts(THotStatusPara qqTHotStatusPara);

    /**
     * 转播热榜，返回QqTResponse
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public TResponse getHotRepostsRes(THotStatusPara qqTHotStatusPara);

    /**
     * 获得数据更新条数，返回字符串
     * 
     * @param format 数据返回格式
     * @param isClear 是否在查看数据后，清除更新数
     * @param clearType 在上面为true时，设置清空的更新数的类型
     * @return
     */
    public String getUpdateInfoNumStr(String format, boolean isClear, int clearType);

    /**
     * 获得数据更新条数，返回QqTUpdateNumInfo
     * 
     * @param isClear 是否在查看数据后，清除更新数
     * @param clearType 在上面为true时，设置清空的更新数的类型
     * @return
     */
    public TUpdateNumInfo getUpdateInfoNum(boolean isClear, int clearType);

    /**
     * 获得数据更新条数，返回QqTResponse
     * 
     * @param isClear 是否在查看数据后，清除更新数
     * @param clearType 在上面为true时，设置清空的更新数的类型
     * @return
     */
    public TResponse getUpdateInfoNumRes(boolean isClear, int clearType);

    /**
     * 收藏一条微博，是否成功收藏
     * 
     * @param statusId 微博id
     * @return
     */
    public boolean collect(long statusId);

    /**
     * 收藏一条微博，返回QqTResponse
     * 
     * @param statusId 微博id
     * @return
     */
    public TResponse collectRes(long statusId);

    /**
     * 取消收藏一条微博，是否成功取消
     * 
     * @param statusId 微博id
     * @return
     */
    public boolean unCollect(long statusId);

    /**
     * 取消收藏一条微博，返回QqTResponse
     * 
     * @param statusId 微博id
     * @return
     */
    public TResponse unCollectRes(long statusId);

    /**
     * 订阅话题，是否成功订阅
     * 
     * @param topicId 话题id
     * @return
     */
    public boolean subscribeTopic(long topicId);

    /**
     * 订阅话题，返回QqTResponse
     * 
     * @param topicId 话题id
     * @return
     */
    public TResponse subscribeTopicRes(long topicId);

    /**
     * 取消订阅话题，是否成功取消
     * 
     * @param topicId 话题id
     * @return
     */
    public boolean unSubscribeTopic(long topicId);

    /**
     * 取消订阅话题，返回QqTResponse
     * 
     * @param topicId 话题id
     * @return
     */
    public TResponse unSubscribeTopicRes(long topicId);

    /**
     * 获取收藏的微博列表<br/>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getCollectStatusesStr(TTimelinePara qqTTimelinePara);

    /**
     * 获取收藏的微博列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getCollectStatusesStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getCollectStatuses(TTimelinePara qqTTimelinePara);

    /**
     * 获取收藏的微博列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getCollectStatusesStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getCollectStatusesRes(TTimelinePara qqTTimelinePara);

    /**
     * 根据话题名称查询话题id<br/>
     * 
     * @param format 返回数据格式
     * @param names 话题名字列表，以逗号分隔，如abc,efg
     * @return 以字符串的形式返回
     */
    public String getTopicIdByNamesStr(String format, String names);

    /**
     * 根据话题名称查询话题id，返回Map
     * 
     * @param format 返回数据格式
     * @param names 话题名字列表，以逗号分隔，如abc,efg
     * @return 以map返回，key为id，value为name
     */
    public Map<String, String> getTopicIdByNames(String names);

    /**
     * 根据话题名称查询话题id，返回QqTResponse
     * 
     * @param format 返回数据格式
     * @param names 话题名字列表，以逗号分隔，如abc,efg
     * @return 返回QqTResponse，data为map，key为id，value为name
     */
    public TResponse getTopicIdByNamesRes(String names);

    /**
     * 根据话题id获取话题相关信息<br/>
     * 
     * @param format 返回数据格式
     * @param ids 话题id列表，以逗号分隔，如12345,12345最多15个
     * @return 以字符串的形式返回
     */
    public String getTopicInfoByIdsStr(String format, String ids);

    /**
     * 根据话题id获取话题相关信息<br/>
     * 
     * @param ids 话题id列表，以逗号分隔，如12345,12345最多15个
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>调用{@link TSdkService#getTopicInfoByIdsStr(String, String)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getTopicInfoByIds(String ids);

    /**
     * 根据话题id获取话题相关信息<br/>
     * 
     * @param ids 话题id列表，以逗号分隔，如12345,12345最多15个
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>调用{@link TSdkService#getTopicInfoByIdsStr(String, String)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getTopicInfoByIdsRes(String ids);

    /**
     * 获取已订阅话题列表<br/>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getCollectTopicsStr(TTimelinePara qqTTimelinePara);

    /**
     * 获取已订阅话题列表<br/>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getCollectTopicsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<TStatus> getCollectTopics(TTimelinePara qqTTimelinePara);

    /**
     * 获取已订阅话题列表<br/>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link TTimelinePara#setFormat(String)}为
     *         {@link TConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link TSdkService#getCollectTopicsStr(TTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public TResponse getCollectTopicsRes(TTimelinePara qqTTimelinePara);

    /**
     * 添加标签，返回字符串
     * 
     * @param format 返回的数据格式
     * @param tagName 标签名
     * @return
     */
    public String addTag(String format, String tagName);

    /**
     * 添加标签，返回是否添加成功
     * 
     * @param tagName 标签名
     * @return
     */
    public boolean addTag(String tagName);

    /**
     * 添加标签，返回QqTResponse
     * 
     * @param tagName 标签名
     * @return
     */
    public TResponse addTagRes(String tagName);

    /**
     * 删除标签，返回字符串
     * 
     * @param format 返回的数据格式
     * @param tagId 标签id
     * @return
     */
    public String deleteTag(String format, String tagId);

    /**
     * 删除标签，返回是否删除成功
     * 
     * @param tagId 标签id
     * @return
     */
    public boolean deleteTag(String tagId);

    /**
     * 删除标签，返回QqTResponse
     * 
     * @param tagId 标签id
     * @return
     */
    public TResponse deleteTagRes(String tagId);

    /**
     * 得到未授权的request token
     * 
     * @param callBackUrl
     * @return
     *         <ul>
     *         <li>map包含oauth_token, oauth_token_secret, oauth_callback_confirmed</li>
     *         </ul>
     */
    public Map<String, String> getUnAuthorizedRequestToken(String callBackUrl);

    /**
     * 得到授权的request token
     * 
     * @param String query url的query部分
     * @return
     *         <ul>
     *         <li>map包含oauth_token, oauth_verifier</li>
     *         </ul>
     */
    public Map<String, String> getAuthorizedRequestToken(String query);

    /**
     * 得到access token
     * 
     * @param oauthToken 获得的oauth token
     * @param oauthVerifier 获得的oauth verifier
     * @param requestTokenSecret 获得临时request token时的token secret
     * @return
     *         <ul>
     *         <li>map包含oauth_token, oauth_token_secret</li>
     *         </ul>
     */
    public Map<String, String> getAccessToken(String oauthToken, String oauthVerifier, String requestTokenSecret);
}
