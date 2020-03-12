package inf;

public class PlusOne {
    public static void main(String[] args) {

//

//		int[] input1 = {1,9,9};

//		int[] input2 = new int[3];

//		int plusNo = 0;

//		int count = 0;

//		boolean flag = false;

//		List<Integer> list = new ArrayList<>();

//

//		for(int i=input1.length-1; i >= 0; i--) {

//			if(flag==false) {

//				plusNo=plus(input1[i]);

//			}else {

//				plusNo=input1[i];

//			}

//			if(plusNo==10&&count==0) {

//				list.add(0);

//				count ++;

//			}else if(count>0){

//				int temp = plusNo+1;

//				count --;

//				if(temp==10) {

//					count ++;

//					list.add(0);

//				}else {

//					list.add(temp);

//				}

//			}else {

//				list.add(plusNo);

//			}

//			flag=true;

//			if(list.size()==input1.length && count>0) {

//				list.add(1);

//			}

//		}

//		System.out.println(Arrays.toString(toArr(list)));

//	}

//

//	public static int plus(int input) {

//		int plusNum = 0;

//		plusNum = input+1;

//		return plusNum;

//	}

//

//	public static Integer[] toArr(List<Integer> list) {

//		Collections.reverse(list);

//		Integer arr[] = list.toArray(new Integer[list.size()]);

//		return arr;

//	}



        int[] input = {1,2,9};

        int[] result = plus(input);

        for(int i:result) {

            System.out.println(i);

        }

    }

    public static int[] plus(int[] input) {

        for(int i=input.length-1; i>=0; i--) {

            if(input[i] !=9) {

                input[i]++;

                break;

            }else {

                input[i]=0;

            }

        }

        if(input[0]==0) {

            int[] result = new int[input.length+1];

            result[0]=1;

            return result;

        }

        return input;

    }
}
