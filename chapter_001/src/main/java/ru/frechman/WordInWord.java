package ru.frechman;

/**
 * Checking that one word contains in another word.
 */
public class WordInWord {

    /**
     * Checking that one word contains in another word.
     *
     * @param origin contains word.
     * @param sub    check IN origin word.
     * @return true, if origin contains sub, else - false.
     */
    public boolean contains(String origin, String sub) {
        boolean result = false;
        int index = 0;
        for (int i = 0; i < origin.length(); i++) {
            for (; index < sub.length();) {
                if (origin.charAt(i) != sub.charAt(index)) {
                    result = false;
                    break;
                } else {
                    index++;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}
