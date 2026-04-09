
import java.util.ArrayList;

/**
 *
 * @author Raghad Saqallah ID:220232444
 */
public class Query {

    private String tableName;
    private ArrayList<String> columns;
    private String whereCondition;
    private String OrderBy;
    private String limit;
    private String Join;

    private Query(builder b) {  // بدلا من وضع البراميتر كلهم
        this.tableName = b.tableName;
        this.Join = b.Join;
        this.columns = b.columns;
        this.whereCondition = b.whereCondition;
        this.OrderBy = b.OrderBy;
        this.limit = b.limit;
    }

    public String getTableName() {
        return tableName;
    }

    public ArrayList<String> getColumns() {
        return this.columns;
    }

    public String getWhereCondition() {
        return whereCondition;
    }

    public String getOrderBy() {
        return OrderBy;
    }

    public String getLimit() {
        return limit;
    }

    public String getJoin() {
        return Join;
    }

    public static class builder {

        private String tableName;
        private ArrayList<String> columns = new ArrayList<>();
        private String whereCondition;
        private String OrderBy;
        private String limit;
        private String Join;

        
        // setters return builder  عشان نستخدم dot بدون set  في كل مرة
      
        
        
        public builder(String tableName) {  // عند عمل object of builder لازم ادخل ال table  و بكدا بصير الزامي ادخاله
            this.tableName = tableName;
        }

        public builder setColumns(String... column) {   // variable length parameter   حيث يتم معاملة المدخل ك array
            for (String s : column) {
                columns.add(s);  // اضافة لليست
            }
            return this;
        }

        public builder setWhereCondition(String whereCondition) {
            this.whereCondition = whereCondition;
            return this;

        }

        public builder setOrderBy(String OrderBy) {
            this.OrderBy = OrderBy;
            return this;

        }

        public builder setLimit(String limit) {
            this.limit = limit;
            return this;

        }

        public builder setJoin(String Join) {
            this.Join = Join;
            return this;

        }


        public Query build() {
            if (columns.isEmpty()) {
                System.out.println("Selcet * From " + tableName);
                return new Query(this);
            }

            System.out.println("Select " + columns + " From " + tableName
                    + " Where " + whereCondition + " Order by " + OrderBy
                    + " Join " + Join + " Limit " + limit);
            return new Query(this);

        }

    }

}
