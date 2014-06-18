package com.github.loafer.mybatis.pagination.dialect;

/**
 * Date Created  14-2-19
 *
 * @author loafer[zjh527@gmail.com]
 * @version 1.0
 */
public class OracleDialect extends Dialect{
    @Override
    public boolean supportsLimit() {
        return true;
    }

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        return getLimiString(sql, offset, Integer.toString(offset), Integer.toString(limit));
    }

    private String getLimiString(final String sql, final int offset,
                                 final String offsetPlaceholder, final String limitPlaceholder){

        StringBuilder pagingSelect = new StringBuilder(sql.length() + 100);
        if (offset >= 0) {
            pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
        } else {
            pagingSelect.append("select * from ( ");
        }
        pagingSelect.append(sql);
        if (offset >= 0) {
//这种写法在0-10时会出现第一页数据错误            String endString = String.valueOf(Integer.parseInt(offsetPlaceholder) + Integer.parseInt(limitPlaceholder));
            String endString = offsetPlaceholder + "+" + limitPlaceholder;
            pagingSelect.append(" ) row_ ) where rownum_ <= ")
                    .append(endString).append(" and rownum_ > ").append(offsetPlaceholder);
        } else {
            pagingSelect.append(" ) where rownum <= ").append(limitPlaceholder);
        }

        return pagingSelect.toString();
    }
}
