This question is quite difficult, as there are many cases that I didn't come up with at beginning. 
Take some cases where I once failed for example:
- `aab, c*a*b`
- `aa, a*`
- `ab, .*`
- `a, .*..a*`
- `bbaa, a...`
- `aaa, a.a`
- `abcaaaaaaabaabcabac .*ab.a.*a*a*.*b*b*`
    - My solution is extremely slow when processing this case, as the recursion is too unnecessarily deep.
My solution is not good. The dp version is much better, and not hard to understand after thinking it well. 
But the time complexity analysis of recursion solution is pretty hard. Luckily, this [article](https://levelup.gitconnected.com/solving-for-recursive-complexity-736439987cb0) provides a detailed explanation. 