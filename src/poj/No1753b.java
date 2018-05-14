package poj;

public class No1753b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numa = {{1,2,3},{2,3,4}};
		for(int i=0;i<numa[0].length;i++) {
			for(int j=0;j<numa.length;j++) {
				System.out.print(numa[j][i] + ' ');
			}
			System.out.println(' ');
		}

	}
	

}
