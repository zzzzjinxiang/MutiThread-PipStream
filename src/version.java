import java.util.ArrayList;

public class version {
    ArrayList<Integer> get(String version)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        char[] ver = version.toCharArray();
        for(int i=0; i<version.length(); i++)
        {
            int j=i,s=0;
            while(j<version.length() && ver[j]!= '.')
            {
                s+= s*10 + ver[j] - '0';
                j++;
            }
            ans.add(s);
            i=j;
        }
        while(ans.size() > 0 && ans.get(ans.size()-1) == 0) ans.remove(ans.size()-1);
        return ans;
    }

/*
    int compareVersion(String version1, String version2) {
        ArrayList<Integer> n1=get(version1);
        ArrayList<Integer> n2=get(version2);
        if(n1<n2) cout<<boolalpha<< true <<endl;
        else cout<<boolalpha<< false <<endl;

        return 0;
    }

    int main()
    {
        compareVersion(str1, str2);
        return 0;
    }

 */
}
