/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

//TC:O(N)
//SC:O(1)
//Did it run successfully on Leetcode? : Yes
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++)
        {
            // look for requirement 1
            if (knows(candidate, i))
            {
                candidate = i;
            }
        }
        
        for (int i = 0; i < n; i++)
        {
            // Skip the condition of candidate knows himself/herself
            
            if (candidate == i) continue;
            
            // If candidate knows i or i doesn't know candidate, then candidate is not celebrity
            if (knows(candidate,i) || !knows(i, candidate))
                return -1;
        }
        return candidate;
    }
}



// However in such problems discussing the naive n^2 algorithm  and then moving to the intuition behind the linear algorithm is what helps remembering the solution the most.

// Adding on to what you just coded.
// The first for loop was to stop at a index which may be the celebrity.
// Because that indexed person does not know any of the persons after it and some people before him may know him if candidate index is  >= 1 and 0 if it is the first person.
//  You still need to check if that index is the correct one, so you check if any other person does not know him and if he knows any other person.
// The answer is -1 or the candidate index.
// However some may be confused if the potential candidate fails why cant there be any candidate indexes after it?
// That is not possible because the potential candidate already does not know anyone after him which is the first step and before him are people who know atleast 1 person.
// So there is no possibility of a celebrity in the right half.