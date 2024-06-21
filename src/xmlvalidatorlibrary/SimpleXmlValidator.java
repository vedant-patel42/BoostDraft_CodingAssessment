package xmlvalidatorlibrary;
import java.util.Stack;

public class SimpleXmlValidator {
    //Please implement this method
    //feel free to add other classes/methods if you want

    /**
     * Validates if the given XML string is well-formed.
     *
     * @param xml The XML string to validate
     * @return true if the XML string is valid, false otherwise
     */

    public static boolean determineXml(String xml) {
        Stack<String> stack = new Stack<>();
        int index = 0;
        int length = xml.length();

        while(index < length){
            char currentChar = xml.charAt(index);
            if(currentChar == '<'){
                int nextIndex = index + 1;
                if(nextIndex < length){
                    if(xml.charAt(nextIndex) == '!'){                               //check valid comment tag
                        if(!checkComments(xml, nextIndex, length)) return false;
                    }
                    else if(xml.charAt(nextIndex) == '_' || (xml.charAt(nextIndex) >= 'a' && xml.charAt(nextIndex) <= 'z') || (xml.charAt(nextIndex) >= 'A' && xml.charAt(nextIndex) <= 'Z')){  //check valid tag_name
                        String tagName = "<" + xml.charAt(nextIndex);
                        nextIndex += 1;
                        while(nextIndex < length && xml.charAt(nextIndex) != '>'){
                            if(xml.charAt(nextIndex) == '_' || (xml.charAt(nextIndex) >= 'a' && xml.charAt(nextIndex) <= 'z') || (xml.charAt(nextIndex) >= 'A' && xml.charAt(nextIndex) <= 'Z') || (xml.charAt(nextIndex) >= '0' && xml.charAt(nextIndex) <= '9') || xml.charAt(nextIndex) == '-'){
                                tagName += xml.charAt(nextIndex);
                                nextIndex += 1;
                            }
                            else if(xml.charAt(nextIndex) == '/' && nextIndex + 1 < length && xml.charAt(nextIndex + 1) == '>'){
                                tagName += xml.charAt(nextIndex);
                                nextIndex += 1;
                                break;
                            }
                            else return false;
                            if(tagName.equals("xml") || tagName.equals("XML")) return false;
                        }
                        if(nextIndex == length) return false;
                        if(xml.charAt(nextIndex) == '>') tagName += xml.charAt(nextIndex);
                        if(xml.charAt(nextIndex - 1) != '/') stack.push(tagName);
                    }
                    else if(xml.charAt(nextIndex) == '/'){ // check valid closing tag
                        String closingTagName = "<";
                        nextIndex += 1;
                        while(nextIndex < length && xml.charAt(nextIndex) != '>'){
                            if(xml.charAt(nextIndex) == '_' || (xml.charAt(nextIndex) >= 'a' && xml.charAt(nextIndex) <= 'z') || (xml.charAt(nextIndex) >= 'A' && xml.charAt(nextIndex) <= 'Z') || (xml.charAt(nextIndex) >= '0' && xml.charAt(nextIndex) <= '9') || xml.charAt(nextIndex) == '-'){
                                closingTagName += xml.charAt(nextIndex);
                                nextIndex += 1;
                            }
                            else return false;
                        }
                        if(nextIndex == length) return false;
                        if(xml.charAt(nextIndex) == '>') closingTagName += xml.charAt(nextIndex);
                        if(stack.isEmpty() || !stack.peek().equals(closingTagName)) return false;
                        stack.pop();
                    }
                }
                else return false;
                index = nextIndex + 1;
            }
            else index += 1;
        }
        return stack.isEmpty();
    }
    private static boolean checkComments(String xml, int nextIndex, int length){
        String comment = "<!";
        while(nextIndex < length && xml.charAt(nextIndex) != '>'){
            if(xml.charAt(nextIndex) == '-') comment += xml.charAt(nextIndex);
            nextIndex += 1;
        }
        if(nextIndex < length) comment += xml.charAt(nextIndex);
        return comment.equals("<!---->");
    }
}