package im.shs.action;

import im.shs.bean.UserBean;
import im.shs.bean.UserCriteria;
import im.shs.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ServletResponseAware {

	private static final long serialVersionUID = 1L;
	@Resource(name = "userService")
	private UserService userService;
	private UserBean user;
	private HttpServletResponse response;
	private Integer page;
	public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private Integer pageSize;

    public String queryUserList() {
	    System.out.println("page:" + this.page + " pageSize:" + this.pageSize);
		try {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();

			UserCriteria criteria = new UserCriteria();
			criteria.setStartIndex((this.page - 1) * this.pageSize);
			criteria.setPageSize(this.pageSize);
			JSONObject json = JSONObject.fromObject(userService
					.getUserList(criteria));
			System.out.println(json.toString());

			out.println(json.toString());
			//out.write("["+json.toString()+"]");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;//"userListBySqlMap";
	}

	public String addUser() {
		userService.addUser(user);
		return "addSucc";
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

}
