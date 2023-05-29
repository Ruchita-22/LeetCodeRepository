class ParkingSystem {
    int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1){
            big--;
            return big >= 0 ? true : false;
        }
        else if(carType == 2){
            medium--;
            return medium >= 0 ? true : false;
        }
        else if(carType == 3){
            small--;
            return small >= 0 ? true : false;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */