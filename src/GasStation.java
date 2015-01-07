public class GasStation {
	public int canCompleteCircuitSlow(int[] gas, int[] cost) {
		for(int i =0;i<gas.length; i++){
			if(canCompleteCircuit(gas, cost, 0, i, 0)){
				return i;
			}
		}
		return -1;
	}
	public boolean canCompleteCircuit(int[] gas, int[] cost, int step, int start, int rest){
		if(step == gas.length){
			return true;
		}
		
		start = start % gas.length;
		return (gas[start] + rest >= cost[start]) && canCompleteCircuit(gas, cost, step + 1, start +1, gas[start] + rest - cost[start]);
		
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		boolean [] memory = new boolean[gas.length];
		for(int i = 0; i< gas.length; i++){
			memory[i] = false;
		}
		int head = 0;
		int size = 0;
		int gasSum = 0;
		int costSum = 0;
		while(memory[head] == false){	
			if(gasSum < costSum){
				memory[head] = true;			
				size --;
				gasSum -= gas[head];
				costSum -= cost[head];
				head = (head + 1) % gas.length;	
				continue;
			}
			if(size == gas.length){
				return head;
			}
			gasSum += gas[(head + size) % gas.length];
			costSum += cost[(head + size) % gas.length];
			size ++;		
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		GasStation s1 = new GasStation();
		int [] gas = {4, 7};
		int [] cost = {5, 9};
		System.out.println(s1.canCompleteCircuit(gas, cost));
	}
}
