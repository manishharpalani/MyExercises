package CodingInterviewsBook

import CodingInterviewsBook.Palindrome

/**
 * Created by manishharpalani on 30/01/17.
 */
class PalindromeTest extends spock.lang.Specification {
    def "isPalindrome"() {
        expect:
        Palindrome.isPalindrome(null) == true
        Palindrome.isPalindrome("") == true
        Palindrome.isPalindrome("") == true
        Palindrome.isPalindrome("a") == true
        Palindrome.isPalindrome("aa") == true
        Palindrome.isPalindrome("aba") == true
        Palindrome.isPalindrome("abba") == true
        Palindrome.isPalindrome("abcba") == true
        Palindrome.isPalindrome("12321") == true
    }

    def "notPalindrome"() {
        expect:
        !Palindrome.isPalindrome("a ")
        !Palindrome.isPalindrome("ab")
        !Palindrome.isPalindrome("ab a")
        !Palindrome.isPalindrome("abc")
        !Palindrome.isPalindrome("abcdba")
        !Palindrome.isPalindrome("123421")
    }

    def "intPalindrome"() {
        expect:
        Palindrome.isPalindrome(0)
        Palindrome.isPalindrome(1)
        Palindrome.isPalindrome(99)
        Palindrome.isPalindrome(159951)
        Palindrome.isPalindrome(98789)
    }

    def "notIntPalindrome"() {
        expect:
        !Palindrome.isPalindrome(12)
        !Palindrome.isPalindrome(123)
        !Palindrome.isPalindrome(2342)
        !Palindrome.isPalindrome(987689)
    }
}
