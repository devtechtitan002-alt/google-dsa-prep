package Revision.Contests;
import java.util.ArrayList;
import java.util.List;

public class P3 {
    public int minLights(int[] lights) {

    int n = lights.length;
    int[] diff = new int[n + 2];

    // Step 1: build coverage using difference array
    for (int i = 0; i < n; i++) {
        if (lights[i] > 0) {
            int v = lights[i];

            int l = Math.max(0, i - v);
            int r = Math.min(n - 1, i + v);

            diff[l] += 1;
            diff[r + 1] -= 1;
        }
    }

    int[] covered = new int[n];
    int cur = 0;

    for (int i = 0; i < n; i++) {
        cur += diff[i];
        covered[i] = cur > 0 ? 1 : 0;
    }

    // Step 2: greedy fill uncovered segments
    int ans = 0;

    for (int i = 0; i < n; ) {

        if (covered[i] == 1) {
            i++;
            continue;
        }

        // uncovered segment starts here
        ans++;

        // place bulb covering [i, i+2]
        i += 3;
    }

    return ans;
}
}
