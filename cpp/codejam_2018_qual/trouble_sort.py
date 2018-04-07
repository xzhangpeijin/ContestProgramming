T = int(raw_input())
for t in xrange(T):
    N = int(raw_input())
    vals = [int(x) for x in raw_input().split(" ")]
    even = sorted(vals[::2])
    odd = sorted(vals[1::2])
    merged = [even[i/2] if i % 2 == 0 else odd[i/2] for i in xrange(N)]
    good = True
    for i in xrange(1, N):
        if merged[i] < merged[i-1]:
            print "Case #{}: {}".format(t+1, i-1)
            good = False
            break
    if good:
        print "Case #{}: OK".format(t+1)
