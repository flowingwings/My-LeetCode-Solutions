According to the official solution:
> The motivation for this is that it turns out we always greedily divide by 2:  
If say `target` is even, then if we perform 2 additions and one division, we could instead perform one division and one addition for less operations [`(target + 2) / 2` vs `target / 2 + 1`].  
If say `target` is odd, then if we perform 3 additions and one division, we could instead perform 1 addition, 1 division, and 1 addition for less operations [`(target + 3) / 2` vs `(target + 1) / 2 + 1`].

How could you come up with this greedy solution? A comment partly explained the thought:
> If with subtraction and multiplication, the effect of earlier subtraction will be amplified by later multiplications, hence, greedily doing multiplication might not reach optimal solution as an additional early subtraction can have a huge effect.  
Whereas with addition and division, earlier addition will be diminished by later divisions. It is thus always better to do division wherever possible.


There is still a question: as we can do division and addition backwards, why not do subtraction and multiplication forwards? Isn't working forwards a more natural approach?

This is because working backwards can decide the end of the process easily, which is `target <= startValue`, and after which we can simply only do some additions. How about working forwards? Of course there is also a end, since when we can simply only do some multiplications, but how could we find it? This end of course should maximize `N` in `end*2^N`, then how to get the end's end? Add 1 and divide by 2? Isn't this process completely working backwards?

The essential difference is that, you can easily decide when to do only additions by comparing, but can hardly decide when to do only multiplications by some algorithm. 