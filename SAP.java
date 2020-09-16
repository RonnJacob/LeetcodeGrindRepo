import java.util.*;
public class SAP{

    public static boolean checkRule(String num){
        for(int i=0; i<num.length()-1; i++){
            if(num.charAt(i)>= num.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    public static void findLargestNumber(String num){
        Integer numToCheck = Integer.parseInt(num);
        while(true){
            if(checkRule(numToCheck.toString())){
                System.out.println(numToCheck);
                break;
            }
            numToCheck--;
        }
    }

    public static int countChars(String member){
        Set<Character> memberLetter = new HashSet<>();
        for(Character c: member.toLowerCase().toCharArray()){
            if(!c.equals(' ')){
                memberLetter.add(c);
            }
        }
        return memberLetter.size();
    }
    public static void getTeamLead(List<String> members){
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : Integer.compare(b.getValue(), a.getValue()));
        Map<String, Integer> letterCount = new HashMap<>();
        for(String member: members){
            letterCount.put(member, countChars(member));
        }
        pq.addAll(letterCount.entrySet());

        System.out.println(pq.poll().getKey());
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		int i = 0;
		List<String> names = new ArrayList<>();
		while (input.hasNextLine() && i<5) {
			names.add(input.nextLine());
			i++;
		}
		getTeamLead(names);
    }
}