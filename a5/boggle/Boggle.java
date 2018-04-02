//Boggle.java
//V00847029 Descoteaux, Marc

import java.util.*;

public class Boggle{
	
	private static boolean debug = false;
	static char[][] boggle;
	static boolean[][] visited;
	static final int[] scores = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    static final int[] mx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] my = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static boolean solve(int x, int y, String word, int pos) {
        if(pos == word.length()){
            return true;
        }

        boolean result = false;
        visited[x][y] = true;
		//move throughout the grid 
        for(int i = 0; i < 8; i++){
            int posx = x + mx[i];
            int posy = y + my[i];
			
			
			//if the position is within the boundaries of the board, and the position hasn't been visited yet, 
			//and the position contains the next letter in the given word, recur and look for the next letter from the given position 
            if(0 <= posx && posx < 4 && 0 <= posy && posy < 4 && !visited[posx][posy] && boggle[posx][posy] == word.charAt(pos)){
				if(debug) System.out.println(posx+" "+posy+" "+boggle[posx][posy]);
                result = result || solve(posx, posy, word, pos + 1);
            }
        }

        visited[x][y] = false;

        return result;
    }
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int w = in.nextInt();
		
		/* this is in case the dictionary gets too big. nevermind just seen the timelimit is 11 seconds
		
		Map<Character, Set<String>> dict = new HashMap<Character, Set<String>>();
		//get dictionary
		for(int i = 0; i < w; i++){
			
			String word = in.next();
			in.nextLine();
			Character first = word.charAt(0);
			if(dict.containsKey(first)){
				Set<String> set = dict.get(first);
				set.add(word);
				dict.put(first, set);
				
			}else{
				Set<String> set = new HashSet<String>();
				set.add(word);
				dict.put(first, set);
			}
		}*/
		
		String[] dict = new String[w];
		for(int i = 0; i < w; i++){
			dict[i] = in.next();
			if(debug) System.out.println(dict[i]);
			in.nextLine();
		}
		
		in.nextLine();
			
		int b = in.nextInt();
		
		in.nextLine();
		
		for(int l = 0; l < b; l++){
			
			boggle = new char[4][4];
			//get boggle 
			for(int j = 0; j < 4; j++){
				boggle[j] = in.next().toCharArray();
				in.nextLine();
			}
			if(debug){
				for(int j = 0; j < 4; j++){
					for(int k = 0; k < 4; k++){
						System.out.print(boggle[j][k]);
					}
					System.out.println("");
				}
				System.out.println("");
			}
			//end get boggle
			//maze searching algorithm
			visited = new boolean[4][4];
            Set<String> found = new HashSet<String>();

            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    for(String word : dict){
						//if the word was already found, skip solving
                        if(found.contains(word)) continue;
						
						//find the position of a word in the dictionary and try to fill it out with solve.
						
                        if(boggle[i][j] == word.charAt(0)){
							if(debug) System.out.println(i+" "+j+" "+boggle[i][j]);
                            if(solve(i, j, word, 1)){
                                found.add(word);
                            }
                        }
                    }
                }
            }
			//tally
			int score = 0; 
			int numFound = found.size();
			String longest = "";
            for(String word : found){
				//if the given word is longer than the longest found, word is the new longest; 
				//or if they are the same length, the lexicographically smallest (compare < 0) is the longest
                if(word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 0)){
                    longest = word;
                }
				//get the score of the word from the scoring sheet
                score += scores[word.length()];
            }
			
			// and output
			
			System.out.println(score+" "+longest+" "+numFound);
			
			
			//next boggle
			if(in.hasNext()) in.nextLine();
			
		}
		
	}
	
}