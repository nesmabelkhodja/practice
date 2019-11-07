class Solution {
    public static List uniqueEmails = new ArrayList<String>();
    public static int numUniqueEmails(String[] emails) {
        for (int i =0; i<emails.length; i++){
            //System.out.println(emails[i]);
            alreadyExists(emails[i]);
        }
        return uniqueEmails.size();
    }
    
    public static void alreadyExists(String email){
        String localName = (email.split("@"))[0];
        String domainName = (email.split("@"))[1];
        //this will be the modified email
        String emailModified = localName;
        
        //check for +
        if (emailModified.indexOf('+') != -1){
            emailModified = (emailModified.split("\\+"))[0];
        }
        //checks for periods:
        if (emailModified.indexOf('.') != -1){
            emailModified = emailModified.replace(".", "");
        }
        
        //join with domain name for full email
        emailModified = emailModified + "@"+ domainName;
        
        //if this is the first email, it is added automatically
        if (uniqueEmails.size() == 0){
            uniqueEmails.add(emailModified);
        }
        else{
            boolean toAdd = true;
            for (int i = 0; i< uniqueEmails.size(); i++){
                //if the modified email is the same as one of the emails already in the list, it does not need to be added
                if ((uniqueEmails.get(i)).equals(emailModified)){
                    toAdd = false;
                }
            }
            if (toAdd == true){
                uniqueEmails.add(emailModified);
            }

        }
        
    }
    
    public static void main(String[] args){
        System.out.println(numUniqueEmails(args));
    }

}