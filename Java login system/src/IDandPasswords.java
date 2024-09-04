import java.util.HashMap;

public class IDandPasswords
{
    HashMap<String, String> loginInfo = new HashMap<String, String>();
    IDandPasswords()
    {
        loginInfo.put("Anas Abazid", "123456789");
        loginInfo.put("Anas", "pizza");
        loginInfo.put("Anas Program", "abc123");
    }
    protected HashMap getLoginInfo()
    {
        return loginInfo;
    }
}
