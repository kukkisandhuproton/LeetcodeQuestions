class Solution {
    public String Neither = "Neither";
    public String v4 = "IPv4";
    public String v6 ="IPv6";
    public String validIPAddress(String queryIP) {
        if(queryIP == null || queryIP.length()==0){
            return Neither;
        }
//        System.out.println(queryIP.length());
        if(queryIP.contains(".")){
            return checkforV4(queryIP);
        }
        else if(queryIP.contains(":")){
            return checkforV6(queryIP);
        }
        else{
            return Neither;
        }
    }
    public String checkforV4(String query){
        if(query == null || query.length()==0){
            return Neither;
        }
        if(query.startsWith(".")|| query.endsWith(".")){
            return Neither;
        }
        String[] strs = query.split("\\.");

        if(strs.length != 4){
            return Neither;
        }
        for(String str:strs){
            System.out.println(str.length());

            if(str == null || str.length()==0 || (str.length()>1 && str.startsWith("0")||str.length()>4)){
                return Neither;
            }
            //check if leading are zero or not            
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(ch < '0' || ch > '9'){
                    return Neither;
                }
            }
            //check if element is greater than 0
            int num = Integer.parseInt(str); 
            if(num<0 || num>255){
                return Neither;
            }
        }
        return v4;
    }

    public String checkforV6(String query){
        if(query== null || query.length()==0){
            return Neither;
        }
        if(query.startsWith(":")||query.endsWith(":")){
            return Neither;
        }
        String[] strs = query.split("\\:");
        if(strs.length!=8){
            return Neither;
        }
        for(String str:strs){
            str = str.toLowerCase();
            if(str == null){
                return Neither;
            }
            if(str.length()>4 || str.length()<1){
                return Neither;
            }
            //check if element is between 1 and 4
            for(int i = 0;i<str.length();i++){
                char ch = str.charAt(i);
                if((ch<'0' || ch >'9')&&(ch!='a'&& ch!='b'&& ch!='c'&& ch!='d'&& ch!='e'&& ch!='f')){
                
                    return Neither;
                }
            }
        }
        return v6;
    }
}
