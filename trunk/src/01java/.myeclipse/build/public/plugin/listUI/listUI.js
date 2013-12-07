/* 
 * FileName:	listUI.js
 * Date: 		2013-08-28 
 * Description:	listUI展示产品列表，仿京东 
 * Author:		suhao
 * Version:		listUI 1.0 
 * Copyright (c) 2013
 */
(function($, window, document) {
	$.addListUI = function(t, p) {
		var owner = $(t);
		//默认参数
		var d = {
			title : false,// 是否包含标题
			url : false, // ajax方式对应的url地址
			method : 'POST', // 数据发送方式
			dataType : 'json', // 数据加载的类型
			width : 'auto',
			page : 1, // 默认当前页
			total : 1, // 总页面数
			pageSize : 20, // 每页默认的结果数
			pageStat : '显示第[ {from} - {to} ]条,共[{total}]个商品',// 显示当前页和总页面的样式
			procMsg : '正在处理,请稍候 ...',// 正在处理的提示信息
			noDataMsg : '没有符合条件的商品',
			bgColor : '#FFF',
			editMode : false,
			showSort : false
		};
		p = $.extend(d, p);//由自定义参数覆盖默认参数
		
		var g = {
			addData	: function(data) {//列表区数据生成与样式渲染
				$(this.loadingDiv).removeClass('loading');
				$(this.loadingDiv).css({'display' : 'none'});
				this.loading = false;
				
				if (data.totalCount == 0) {
					var noData = document.createElement('div');
					$(noData).addClass('noDataMsg');
					$(noData).text(p.noDataMsg);
					owner.append(noData);
					return false;
				}
				
				var info = document.createElement('div');
				$(info).addClass('listInfo');
				var pages = Math.ceil(data.totalCount / p.pageSize);//总页数
				//创建排序
				var sort = document.createElement('div');
				$(sort).addClass('listInfoSort');
				if (p.showSort) {
					var sortBtn = document.createElement('div');
					$(sortBtn).addClass('listInfoSortBtn');
					var sortText = document.createElement('span');
					$(sortText).addClass('listInfoSortDes');
					$(sortText).text('排序:');
					$(sortBtn).append(sortText);
					for (i = 1; i <= p.showSort.length; i++) {
						var sortCate = document.createElement('a');
						var sortTmp = (p.showSort[i-1]);
						var sortName = sortTmp.name;
						(p.showSort[i-1]).action;
						$(sortCate).addClass('listInfoSortCate').text(sortName).attr('href', '#');
						$(sortCate).bind('click', {index : i}, function () {
							this.params = [];
							this.params[i-1] = sortTmp.sortName;
							g.populate(p.page);
						});
						$(sortBtn).append(sortCate);
					}
					
					
					//排序-销量
					/*var sortSalNum = document.createElement('a');
					$(sortSalNum).addClass('listInfoSortBySale').text('销量').attr('href', '#');
					$(sortBtn).append(sortSalNum);*/
					//排序-价格
					/*var sortPrice = document.createElement('a');
					$(sortPrice).addClass('listInfoSortByPrice').text('价格').attr('href', '#');
					$(sortBtn).append(sortPrice);*/
					$(sort).append(sortBtn);
				}
				//顶部数量及分页展示
				var pageInfo = document.createElement('div');
				$(pageInfo).addClass('listInfoSortPage');
				var totalNum = document.createElement('span');
				$(totalNum).addClass('listInfoSortTotal');
				$(totalNum).text('共' + data.totalCount + '个商品');
				$(pageInfo).append(totalNum);
				
				var pageShow = document.createElement('span');
				$(pageShow).addClass('listInfoPageShow');
				var currentPageShow = document.createElement('b');
				$(currentPageShow).addClass('listInfoCurrentPageShow');
				$(pageShow).append(currentPageShow);
				$(currentPageShow).text(p.page);
				var pageTotalShowText = '/' + pages;
				var totalPageShow = document.createElement('b');
				$(totalPageShow).addClass('listInfoTotalPageShow');
				$(pageShow).append(totalPageShow);
				$(totalPageShow).text(pageTotalShowText);
				$(pageInfo).append(pageShow);
				
				var prePage = document.createElement('a');
				$(prePage).addClass('listInfoPrev');
				$(prePage).attr('href', '#').text('上一页');
				$(prePage).hover(
					function() {
						$(this).addClass('prevAndNextHover');
					}, function() {
						$(this).removeClass('prevAndNextHover');
					}
				);
				var preTagB = document.createElement('b');
				$(prePage).append(preTagB);
				if (p.page == 1) {
					$(prePage).css({'color' : '#DDD', 'background-color' : '#F7F7F7'});
					$(preTagB).css({
						'background' : 'url(public/plugin/listUI/image/bg_listUI.gif) no-repeat -80px -608px'
					});
					$(prePage).removeAttr('href');
				} else {
					$(preTagB).removeAttr("style");
				}
				if (p.page > 1) {
					$(prePage).bind('click', function() {
						
						p.page -= 1;
						g.populate(p.page);
					});
				}
				$(pageInfo).append(prePage);
				var nextPage = document.createElement('a');
				$(nextPage).addClass('listInfoNext');
				$(nextPage).attr('href', '#').text('下一页');
				$(nextPage).hover(
					function() {
						$(this).addClass('prevAndNextHover');
					}, function() {
						$(this).removeClass('prevAndNextHover');
					}
				);
				var nextTagB = document.createElement('b');
				$(nextPage).append(nextTagB);
				if (p.page == pages) {
					$(nextPage).css({'color' : '#DDD', 'background-color' : '#F7F7F7'});
					$(nextTagB).css({
						'background' : 'url(public/plugin/listUI/image/bg_listUI.gif) no-repeat -74px -608px'
					});
					$(nextPage).removeAttr('href');
				} else {
					$(nextTagB).removeAttr("style");
				}
				if (p.page >= 1 && p.page < pages) {
					$(nextPage).bind('click', function() {
						$(prePage).removeAttr("style");
						$(preTagB).removeAttr("style");
						p.page += 1;
						g.populate(p.page);
					});
				}
				$(pageInfo).append(nextPage);
				$(sort).append(pageInfo);
				$(info).append(sort);
				//列表主体数据展示
				$.each(data.data, function(i, n) {
					var ul = document.createElement('ul');
					$(ul).addClass('listInfoUl');
					
					var li = document.createElement('li');
					$(li).addClass('listInfoLi');
					$(ul).append(li);
					
					var spanImg = document.createElement('span');
					$(spanImg).addClass('listInfoLiSpanImg');
					$(spanImg).text(n.name);
					$(li).append(spanImg);
					
					var spanName = document.createElement('span');
					$(spanName).addClass('listInfoLiSpanName');
					var spanNameText = n.name;
					if (spanNameText.length > 20) {
						spanNameText = (n.name).substring(0,14) + "...";
					}
					$(spanName).text(spanNameText);
					$(li).append(spanName);
					
					var spanPrice = document.createElement('span');
					$(spanPrice).addClass('listInfoLiSpanPrice');
					var strPrice = '￥' + n.age;
					$(spanPrice).text(strPrice);
					$(li).append(spanPrice);
					
					if (p.editMode == true) {
						var spanEditAndDel = document.createElement('span');
						$(spanEditAndDel).addClass('listInfoLiSpanEditAndDel');
						
						var editBtn = document.createElement('a');
						$(editBtn).attr('href', '#');
						$(editBtn).text('编辑');
						
						var delBtn = document.createElement('a');
						$(delBtn).attr('href', '#');
						$(delBtn).text('删除');
						
						$(spanEditAndDel).append(editBtn).append(delBtn);
						$(li).append(spanEditAndDel);
					} else {
						var spanCart = document.createElement('span');
						$(spanCart).addClass('listInfoLiSpanCart');
						var cartBtn = document.createElement('a');
						$(cartBtn).attr('href', '#');
						$(cartBtn).text('加入购物车');
						$(spanCart).append(cartBtn);
						$(li).append(spanCart);
					}
					
					$(info).append(ul);
				});
				owner.append(info);
				var clearFloat = document.createElement('div');
				$(clearFloat).addClass('clear');
				owner.append(clearFloat);
				//构建列表底部
				g.build(data);
			},
			build : function(data) {
				var listBottom = document.createElement('div');
				$(listBottom).addClass('listBottom');
				var totalNum = document.createElement('span');
				var stat = p.pageStat;
				stat = stat.replace(/{from}/, (p.page - 1) * p.pageSize + 1);
				if ((p.page - 1) * p.pageSize + p.pageSize > data.totalCount) {
					stat = stat.replace(/{to}/, data.totalCount);
				} else {
					stat = stat.replace(/{to}/, (p.page - 1) * p.pageSize + p.pageSize);
				}
				stat = stat.replace(/{total}/, data.totalCount);
				$(totalNum).text(stat);
				$(listBottom).append(totalNum);
				
				var pages = Math.ceil(data.totalCount / p.pageSize);//总页数
				var pageNavBox = document.createElement('div');
				$(pageNavBox).addClass('listInfoPageNavBox');
				
				var prePage = document.createElement('a');
				$(prePage).addClass('listInfoPrev');
				$(prePage).attr('href', '#').text('上一页');
				$(prePage).hover(
					function() {
						$(this).addClass('prevAndNextHover');
					}, function() {
						$(this).removeClass('prevAndNextHover');
					}
				);
				var preTagB = document.createElement('b');
				$(prePage).append(preTagB);
				if (p.page == 1) {
					$(prePage).css({'color' : '#DDD', 'background-color' : '#F7F7F7'});
					$(preTagB).css({
						'background' : 'url(public/plugin/listUI/image/bg_listUI.gif) no-repeat -80px -608px'
					});
					$(prePage).removeAttr('href');
				} else {
					$(preTagB).removeAttr("style");
				}
				if (p.page > 1) {
					$(prePage).bind('click', function() {
						
						p.page -= 1;
						g.populate(p.page);
					});
				}
				$(pageNavBox).append(prePage);
				
				if (pages > 0 && pages <= 6) {
					for (i = 1; i <= pages; i++) {
						var pageNav = document.createElement('a');
						$(pageNav).addClass('listInfoPageNav');
						$(pageNav).attr('href', '#');
						$(pageNav).text(i);
						$(pageNavBox).append(pageNav);
						$(pageNav).attr('id', 'pageNav' + i);
						if (i != p.page) {
							$(pageNav).addClass('listInfoPageNavHover');
							$(pageNav).bind('click', {index : i}, function(event) {
								var pageIndex = event.data.index;
								
								g.populate(pageIndex);
							});
						} else {
							$(pageNav).addClass('listInfoPageNavCurrent');
						}
					}
				} else {
					if (p.page == 1 || p.page == 2 || p.page == 3) {
						for (i = 1; i < 7; i++) {
							var pageNav = document.createElement('a');
							$(pageNav).addClass('listInfoPageNav');
							$(pageNav).attr('href', '#');
							$(pageNav).text(i);
							$(pageNavBox).append(pageNav);
							$(pageNav).attr('id', 'pageNav' + i);
							if (i != p.page) {
								$(pageNav).addClass('listInfoPageNavHover');
								$(pageNav).bind('click', {index : i}, function(event) {
									var pageIndex = event.data.index;
									g.populate(pageIndex);
								});
							} else {
								$(pageNav).addClass('listInfoPageNavCurrent');
							}
							
						}
						var ignorePage = document.createElement('a');
						$(ignorePage).text('...');
						$(ignorePage).addClass('listInfoPageNav');
						$(pageNavBox).append(ignorePage);
						
						var lastPage = document.createElement('a');
						$(lastPage).addClass('listInfoPageNav');
						$(lastPage).addClass('listInfoPageNavHover');
						$(lastPage).attr('href', '#');
						$(lastPage).text(pages);
						$(lastPage).bind('click', {index : pages}, function(event) {
							var pageIndex = event.data.index;
							g.populate(pageIndex);
						});
						$(pageNavBox).append(lastPage);
						
					} else {
						var firstPage = document.createElement('a');
						$(firstPage).addClass('listInfoPageNav');
						$(firstPage).attr('href', '#');
						$(firstPage).text(1);
						$(firstPage).bind('click', function() {
							g.populate(1);
						});
						$(firstPage).addClass('listInfoPageNavHover');
						$(pageNavBox).append(firstPage);
						
						if (p.page - 2 != 2 && pages - 6 > 2) {
							var ignorePageFirst = document.createElement('a');
							$(ignorePageFirst).text('...');
							$(ignorePageFirst).addClass('listInfoPageNav');
							$(pageNavBox).append(ignorePageFirst);
						}
						
						if (p.page + 4 < pages) {
							for (i = p.page - 2; i <= p.page + 2; i++) {
								var pageNav = document.createElement('a');
								$(pageNav).addClass('listInfoPageNav');
								$(pageNav).attr('href', '#');
								$(pageNav).text(i);
								$(pageNavBox).append(pageNav);
								$(pageNav).attr('id', 'pageNav' + i);
								if (i != p.page) {
									$(pageNav).addClass('listInfoPageNavHover');
									$(pageNav).bind('click', {index : i}, function(event) {
										var pageIndex = event.data.index;
										g.populate(pageIndex);
									});
								} else {
									$(pageNav).addClass('listInfoPageNavCurrent');
								}
							}
							if (p.page + 5 != pages) {
								var ignorePageLast = document.createElement('a');
								$(ignorePageLast).text('...');
								$(ignorePageLast).addClass('listInfoPageNav');
								$(pageNavBox).append(ignorePageLast);
							}
						} else if (p.page + 4 >= pages) {
							for (i = pages - 6; i < pages; i++) {
								var pageNav = document.createElement('a');
								$(pageNav).addClass('listInfoPageNav');
								$(pageNav).attr('href', '#');
								$(pageNav).text(i);
								$(pageNavBox).append(pageNav);
								$(pageNav).attr('id', 'pageNav' + i);
								if (i != p.page) {
									$(pageNav).addClass('listInfoPageNavHover');
									$(pageNav).bind('click', {index : i}, function(event) {
										var pageIndex = event.data.index;
										g.populate(pageIndex);
									});
								} else {
									$(pageNav).addClass('listInfoPageNavCurrent');
								}
							}
						}
						
						var lastPage = document.createElement('a');
						$(lastPage).addClass('listInfoPageNav');
						if (p.page == pages) {
							$(lastPage).addClass('listInfoPageNavCurrent');
						} else {
							$(lastPage).addClass('listInfoPageNavHover');
						}
						$(lastPage).attr('href', '#');
						$(lastPage).text(pages);
						$(lastPage).bind('click', {index : pages}, function(event) {
							var pageIndex = event.data.index;
							g.populate(pageIndex);
						});
						$(pageNavBox).append(lastPage);
					}
				}
				$(listBottom).append(pageNavBox);
				
				var nextPage = document.createElement('a');
				$(nextPage).addClass('listInfoNext');
				$(nextPage).attr('href', '#').text('下一页');
				$(nextPage).hover(
					function() {
						$(this).addClass('prevAndNextHover');
					}, function() {
						$(this).removeClass('prevAndNextHover');
					}
				);
				var nextTagB = document.createElement('b');
				$(nextPage).append(nextTagB);
				if (p.page == pages) {
					$(nextPage).css({'color' : '#DDD', 'background-color' : '#F7F7F7'});
					$(nextTagB).css({
						'background' : 'url(public/plugin/listUI/image/bg_listUI.gif) no-repeat -74px -608px'
					});
					$(nextPage).removeAttr('href');
				} else {
					$(nextTagB).removeAttr("style");
				}
				if (p.page >= 1 && p.page < pages) {
					$(nextPage).bind('click', function() {
						$(prePage).removeAttr("style");
						$(preTagB).removeAttr("style");
						p.page += 1;
						g.populate(p.page);
					});
				}
				$(pageNavBox).append(nextPage);
				
				owner.append(listBottom);
			},
			populate : function(page) {
				owner.html('');
				if (!page) {
					p.page = 1;
				} else {
					p.page = page;
				}
				owner.addClass('listUI');
				var title = document.createElement('div');
				$(title).addClass('listTitle');
				var t = $(title).text(p.title);
				owner.append(t);
				owner.css({'width' : p.width, 'margin' : '0 auto'});
				
				if (this.loading) {
					return true;
				}
				this.loading = true;
				if (!p.url) {
					return false;
				}
				this.loadingDiv = document.createElement('div');
				$(this.loadingDiv).addClass('loading');
				$(this.loadingDiv).text(p.procMsg);
				owner.append(this.loadingDiv);
				this.params;
				alert(this.params);
				
				var param = [{
					name : 'page',
					value : p.page
				}, {
					name : 'pageSize',
					value : p.pageSize
				}];

				if (p.params) {
					for ( var pi = 0; pi < p.params.length; pi++)
						param[param.length] = p.params[pi];
				}
				$.ajax({
					type : p.method,
					url : p.url,
					data : param,
					dataType : p.dataType,
					success : function(data) {
						g.addData(data);
					},
					error : function(data) {
						try {
							if (p.onError)
								p.onError(data);
						} catch (e) {
						}
					}
				});
			}
		};
		g.populate();
	};

	var docloaded = false;

	$(document).ready(function() {
		docloaded = true;
	});

	$.fn.listUI = function(p) {

		return this
				.each(function() {
					 if (!docloaded) {
						$(this).hide();
						var t = this;
						$(document).ready(function() {
							$.addListUI(t, p);
						});
					} else {
						$.addListUI(this, p);
					}
					 
					
				});
	};
	$.KBox = {
		// Default setting of this plugin.
		opts : {
			boxContent : 'Hello KBox!',
			boxWidth : '400px',
			boxHeight : '200px',
			boxBgColor : '#fff',
			boxSdColor : '#666',
			boxFontFamily : 'Arial',
			boxFontColor : '#000'
		},

		// Show the box
		show : function(options) {
			if (typeof options === 'string') {
				$.extend(this.opts, {
					boxContent : options
				});
			} else {
				$.extend(this.opts, options);
			}

			// Make a background for page
			$('<div id="kboxback"></div>').css({
				'position' : 'fixed',
				'top' : '0px',
				'left' : '0px',
				'width' : '100%',
				'height' : '100%',
				'background' : '#000',
				'z-index' : '9999',
				'opacity' : '0'
			}).appendTo($('body')).animate({
				'opacity' : '.5'
			}, 300, 'linear');

			// The box we want to show
			$('<div id="kboxfront"></div>').css(
					{
						'position' : 'fixed',
						'top' : (($(window).height() - this.opts.boxHeight
								.replace('px', '')) / 2)
								+ 'px',
						'left' : (($(window).width() - this.opts.boxWidth
								.replace('px', '')) / 2)
								+ 'px',
						'width' : this.opts.boxWidth,
						'height' : this.opts.boxHeight,
						'background' : this.opts.boxBgColor,
						'margin' : '0px',
						'padding' : '13px 10px 10px 10px',
						'border-radius' : '9px',
						'box-shadow' : '10px 10px 5px ' + this.opts.boxSdColor,
						'z-index' : '10000',
						'opacity' : '0',
						'word-wrap' : 'break-all',
						'font-family' : this.opts.boxFontFamily,
						'color' : this.opts.boxFontColor
					}).html(
					'<p style="line-height:1.4">' + this.opts.boxContent
							+ '</p>').appendTo($('body')).animate({
				'opacity' : '1'
			}, 300, 'linear');
			;

			// CLose button
			$('<div id="kboxclose"></div>').css({
				'position' : 'absolute',
				'right' : '10px',
				'top' : '7px',
				'cursor' : 'pointer',
				'font-family' : 'Arial',
				'font-weight' : 'bold',
				'color' : '#000'
			}).html('X').appendTo($('#kboxfront')).click(function() {
				$('#kboxfront, #kboxback').animate({
					'opacity' : '0'
				}, 300, 'linear', function() {
					$(this).remove();
				});
			});

			// Handle the 'ESC' key
			$(document).keyup(function(e) {
				if (e.keyCode === 27) {
					$('#kboxfront, #kboxback').animate({
						'opacity' : '0'
					}, 300, 'linear', function() {
						$(this).remove();
					});
				}
			});

			// Retset the #kboxfront's position when window is resizing...
			$(window)
					.resize(
							function() {
								$('#kboxfront')
										.css(
												{
													'top' : (($(window)
															.height() - $.KBox.opts.boxHeight
															.replace('px', '')) / 2)
															+ 'px',
													'left' : (($(window)
															.width() - $.KBox.opts.boxWidth
															.replace('px', '')) / 2)
															+ 'px'
												});
							});
		}
	};
})(jQuery, window, document);