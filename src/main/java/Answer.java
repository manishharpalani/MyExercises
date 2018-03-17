/*
 * This is the file with your answer, do not rename or move it.
 * Write your code in it, and save it before submitting your answer.
 */

public class Answer
{

    private static class InvalidPhoneNumber extends RuntimeException {}
    /**
    * Normalize a given phone number. 
    *
    * This method declaration must be kept unmodified.
    *
    * @param String telephoneNumber: A string containing a phone number.
    * @return String with the normalized phone number if the input phone is 
    *         valid, or '' otherwise.
    */
    public static String standardizePhoneNumber(String telephoneNumber)
    {
        String[] strArray = telephoneNumber.split("[() - .]");

        StringBuffer standardNumber = new StringBuffer();
        for(char ch: telephoneNumber.toCharArray()) {
            if (ch >='0' && ch <= '9')
                standardNumber.append(ch);

            if (standardNumber.length() > 10)
                break;
        }
        if (standardNumber.length() == 10) {
            standardNumber.insert(3, '-');
            standardNumber.insert(7, '-');
            return standardNumber.toString();
        }
        else
            return "";

        // Write your implementation here


    }


    // This tests your code with the examples given in the question, 
    // and is provided only for your convenience.
    public static void main(String[] args)
    {
        String[] phoneNumbers = {"(650) 555-1234", "65.0555.1234",
                                 "65/05/5512/34", "(650) 555-1234 x111",
                                 "(650) 555-123"};
        for (String telephoneNumber : phoneNumbers)
        {
            System.out.println(standardizePhoneNumber(telephoneNumber));
        }
    }
}
