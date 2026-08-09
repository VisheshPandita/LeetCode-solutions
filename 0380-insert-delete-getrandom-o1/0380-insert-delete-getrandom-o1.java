class RandomizedSet {
    private List<Integer> values;              // for O(1) getRandom via index
    private Map<Integer, Integer> valueToIndex; // value -> its index in `values`
    private Random rand;

    public RandomizedSet() {
        values = new ArrayList<>();
        valueToIndex = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) return false;   // already present

        valueToIndex.put(val, values.size());               // record its future index
        values.add(val);                                     // append to the end — O(1) amortized
        return true;
    }

    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) return false;    // not present

        int indexToRemove = valueToIndex.get(val);
        int lastValue = values.get(values.size() - 1);

        // SWAP: move the last element into the slot being vacated
        values.set(indexToRemove, lastValue);
        valueToIndex.put(lastValue, indexToRemove);           // update the moved element's index

        // now remove the true duplicate sitting at the end
        values.remove(values.size() - 1);                     // O(1) — removing from the END, not the middle
        valueToIndex.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(values.size());
        return values.get(randomIndex);
    }
}