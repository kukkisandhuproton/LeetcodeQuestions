class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0;i<=rowIndex;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++ )
                if(i==j||j==0){
                    row.add(1);
                }
                else{
                    row.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
                }
                result.add(row);
        }
        for(List<Integer> row:result){
            for(int num:row){
                System.out.println(num);
            }
            System.out.println("********");
        }
        ArrayList<Integer> num = new ArrayList<>();
        return result.get(rowIndex);
    }
}
