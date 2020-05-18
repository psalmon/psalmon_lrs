import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.Assertions.assert



class LongestRepeatingSubstringTest extends AnyFlatSpec with Matchers {
  "LRS of abracadabra" should "evaluate as 'abra'" in {
    val lrs = LongestRepeatingSubstring.longestRepeatingSubstring("abracadabra")
    assert(lrs.equals("abra"))
  }

  "LRS of 'a'" should "be empty as it does not repeat" in {
    val lrs = LongestRepeatingSubstring.longestRepeatingSubstring("a")
    lrs.shouldBe(empty)
  }

  "LRS of 'aaa'" should "be 'aa' since it repeats" in {
    val lrs: String = LongestRepeatingSubstring.longestRepeatingSubstring("aaa")
    assert(lrs.equals("aa"))
  }
}
