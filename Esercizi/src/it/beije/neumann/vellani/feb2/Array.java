package it.beije.neumann.vellani.feb2;

public class Array {

	
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {
				1, 2, 4, 5, 7
		};
		
		String[] arrString = new String[] {
			"Milano",
			"Bologna",
			"Roma"
		};
		
		System.out.println(Array.trovaMassimo(arr));
		System.out.println(Array.trovaIndiceMassimo(arr));
		System.out.println(Array.contains(3, arr));
		System.out.println(Array.isCrescente(arr));
		System.out.println(Array.mostRecurrent(arr));
		System.out.println(Array.MediaMultipliDiTre(arr));
		Array.StampaZigZag(arr);
		System.out.println(Array.addString("Napoli", arrString));
		
		
		
	}
	
	public static int trovaMassimo(int[] arr) {
		int max = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}


	public static int trovaIndiceMassimo(int[] arr) {
		int max = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = i;
			}
		}
		return max;
	}
	
	public static boolean contains(int e, int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == e) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isCrescente(int[] arr) {
		
		boolean flag = false;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] >= arr[i - 1] ) {
				flag = true;
			} else {
				return false;
			}
		}
		return flag;
	}
	
	public static int mostRecurrent(int[] arr) {
	    int mostRecurrent = 0;
	    int maxCount = 0;

	    for (int i = 0; i < arr.length; i++) {
	        int count = 1;
	        for (int j = i + 1; j < arr.length; j++) {
	            if (arr[j] == arr[i]) {
	                count++;
	            }
	        }
	        if (count > maxCount) {
	            maxCount = count;
	            mostRecurrent = arr[i];
	        }
	    }
	    return mostRecurrent;
	}
	
	public static double MediaMultipliDiTre(int[] arr) {
		double media = 0;
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 3 == 0) {
				media += arr[i];
				count++;
			}
		}
		return media / count;
	}
	
	public static void StampaZigZag(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            if (start == end) {
                System.out.print(arr[start] + " ");
            } else {
                System.out.print(arr[start] + " ");
                System.out.print(arr[end] + " ");
            }

            start++;
            end--;
        }
	}
	
	public static void Media(int[] arr) {
		double media = 0;
		
		for(int i = 0; i < arr.length; i++) {
			media += arr[i];
		}
		System.out.println("Media: " + media/arr.length);
	}
	
	public static String [] addString(String s, String[] a) {
		String[] arrCopia = new String[a.length+1];
		
		for(int i = 0; i < a.length; i++) {
			arrCopia[i] = a[i];
		}
		
		arrCopia[a.length] = s;
		
		return arrCopia;
	}
	
}
