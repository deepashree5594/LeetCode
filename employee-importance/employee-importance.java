/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
​
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if ( employees == null || employees.size() == 0)
            return 0;
        HashMap<Integer, Employee> map = new HashMap();
        for ( Employee employee : employees)
        {
            map.put(employee.id, employee);
        }
        // BFS
        Queue<Integer> q = new LinkedList();
        q.offer(id);
        int importanceCount = 0;
        while (!q.isEmpty())
        {
            Integer e_id = q.poll();
            Employee e = map.get(e_id);
            importanceCount = importanceCount + e.importance;
            for (Integer subordinate: e.subordinates)
            {
                q.add(subordinate);
            }
        }
        return importanceCount;
    }
}
