public interface Motorized {

  void fuelFilling(int number);

   default int getFuel(){
        return 0;
    }

    
}
