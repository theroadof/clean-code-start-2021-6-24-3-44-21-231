#### 神秘命名变量o不可读，改成order提高可读性
#### 提取魔数"======Printing Orders======\n", "Sales Tax", "Total Amount"
#### 神秘命名变量totSalesTx不可读，改成totalSalesTax提高可读性
#### 神秘命名变量tot不可读，改成totalAmountOfLineItem提高可读性
#### DeadCode 方法printCustomerName， 删除
#### 提取printSingleItem方法，提高可读性
#### 魔数.10不可读，提取成SALES_TAX_RATE_PERCENT常量提高可读性
#### 删除DeadCode 代码与歧义注释 
>         // print date, bill no, customer name
>  //        output.append("Date - " + order.getDate();
>
>  //        output.append(order.getCustomerLoyaltyNumber());