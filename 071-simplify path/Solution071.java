public class Solution071 {
    //Attempt1: 347ms
    public String simplifyPath(String path) {
        if (path == null)
            return "";
        String[] segments = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < segments.length; ++i) {
            if ("".equals(segments[i]) || ".".equals(segments[i]))
                continue;
            else if ("..".equals(segments[i])) {
                if (!stack.empty())
                    stack.pop();
            }
            else
                stack.push(segments[i]);
        }

        String ret = "";
        while (!stack.empty()) {
            ret = "/" + stack.pop() + ret;
        }
        if ("".equals(ret))
            ret = "/";

        return ret;
    }
}
