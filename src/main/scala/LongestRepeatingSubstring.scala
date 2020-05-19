object LongestRepeatingSubstring extends App{
  val s  = scala.io.StdIn.readLine("Input String: ")
  println(longestRepeatingSubstring(s))

  //O(N) lookup time because in the worst cast we search the entire array.

    def longestRepeatingSubstring(s: String): String = {
      val strLen  = s.length
      var suffixes: Array[String] = new Array[String](strLen)
      //A suffix for each index
      for (i <- suffixes.indices) {
        suffixes(i) = s.substring(i)
      }
      //Sorting almost always makes life easier :)
      //In this case we are sorting because if the sorted suffix array shares a prefix with it's neighbor, then we know they have all of those letters in common.
      suffixes = suffixes.sorted
      //longest repeating substring var
      var lrs  = ""
      for (i <- 0 until strLen - 1) {
        val len  = longestCommonPrefix(suffixes(i), suffixes(i + 1))
        if (len >= 0 && len > lrs.length) lrs = suffixes(i).substring(0, len + 1)
      }
      lrs
    }

  def longestCommonPrefix(s: String, ss: String): Int = {
    var i  = 0
    while (i < s.length) {
      if (s.charAt(i) != ss.charAt(i)) return i-1
      i += 1
    }
    i - 1
  }

  }