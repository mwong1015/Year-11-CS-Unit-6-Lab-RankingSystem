public class User {
    int progress;
    int rank;


    public User() {
        rank = -8;
        progress = 0;

    }

    public int getProgress() {
        return progress;
    }

    public int getRank() {
        return rank;
    }

    public void incProgress(int rankOfActivity) {
        if(!((rankOfActivity<-8)||(rankOfActivity==0)||(rankOfActivity>8))){ //
            if (rankOfActivity > rank){
                if((rank<0)&&(rankOfActivity>0)){
                    progress += 10*Math.pow(rankOfActivity - rank-1, 2);
                }
                else
                    progress += 10*Math.pow(rankOfActivity - rank, 2);
            }
            else {
                if (rankOfActivity == rank) { // one rank higher, they get only 1
                    progress += 3;
                }
                if ((rankOfActivity == rank - 1) || ((rankOfActivity == -1) && (rank == 1))) {
                    progress++;
                }
            }
        }
        else
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        while (progress >= 100){
            progress -= 100;
            if(rank== -1){
                rank = 1;
            }
            else
                rank++;
        }
    }
    public String toString(){
        return "User{" + "rank=" + rank + ", progress=" + progress + '}';
    }



}

//    User user = new User(); user.getRank(); // => -8 user.getProgress();
// => 0 user.incProgress(-7); user.getProgress();
// => 10 user.incProgress(-5); will add 90 progress user.getProgress(); => 0
// progress is now zero user.getRank(); => -7
// rank was upgraded to -7 user.incProgress(0); an IllegalArgumentException will be thrown.
//The message “The rank of an activity cannot be less than 8, 0, or greater than 8!” will be the message displayed as part of this thrown exception.

//If a user ranked -8 completes an activity ranked -7 they will receive 10 progress
// If a user ranked -8 completes an activity ranked -6 they will receive 40 progress
// If a user ranked -8 completes an activity ranked -5 they will receive 90 progress
// If a user ranked -8 completes an activity ranked -4 they will receive 160 progress,
// resulting in the user being upgraded to rank -7 and having earned 60 progress towards their next rank
// If a user ranked -1 completes an activity ranked 1 they will receive 10 progress (remember, zero rank is ignored)