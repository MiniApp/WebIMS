package im.shs.model;
import java.io.Serializable;

/**    
 *         
 * Class Name：
 *			TUserEduInfo    
 * Description：    
 *			腾讯微博用户教育信息
 * @Author	suhao
 * @Date	2013-12-19 下午10:04:39    
 * @Version	
 *     
 */
public class TUserEduInfo implements Serializable {

    private static final long serialVersionUID = -623843187140208710L;

    private long              id;                                     // 学历记录id
    private String            year;                                   // 入学年
    private long              schoolId;                               // 学校id
    private long              departmentId;                           // 院系id
    private int               level;                                  // 学历级别

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
