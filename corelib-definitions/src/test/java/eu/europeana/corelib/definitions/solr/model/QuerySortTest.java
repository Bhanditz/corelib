package eu.europeana.corelib.definitions.solr.model;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Patrick Ehlert
 * Created on 10-04-2018
 */
public class QuerySortTest {

    /**
     * Test whether we recognize a sort order specification properly
     */
    @Test
    public void testSortOrder() {
        assertTrue(QuerySort.isSortOrder("ascending"));
        assertTrue(QuerySort.isAscending("ascending"));

        assertTrue(QuerySort.isSortOrder("DESCENDING"));
        assertFalse(QuerySort.isAscending("DESCENDING"));

        assertTrue(QuerySort.isSortOrder(" Asc "));
        assertTrue(QuerySort.isAscending(" Asc "));

        assertTrue(QuerySort.isSortOrder(" desC "));
        assertFalse(QuerySort.isAscending(" desC "));

        assertFalse(QuerySort.isSortOrder("descendingggg"));
        assertFalse(QuerySort.isSortOrder(" "));
        assertFalse(QuerySort.isSortOrder(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortOrderIllegal() {
        new QuerySort("test", "descendingggg");
    }

    /**
     * Test construction of a QuerySort object (containing sort field and sort order)
     */
    @Test
    public void testSortField() {
        QuerySort lowercase = new QuerySort("id asc");
        assertEquals("id", lowercase.getSortField());
        assertEquals(QuerySort.ORDER_ASC, lowercase.getSortOrder());

        QuerySort mixedCase = new QuerySort("COMPLETENESS+DEScENDING");
        assertEquals("COMPLETENESS", mixedCase.getSortField());
        assertEquals(QuerySort.ORDER_DESC, mixedCase.getSortOrder());

        QuerySort noOrder = new QuerySort("timestamp");
        assertEquals("timestamp", noOrder.getSortField());
        assertEquals(QuerySort.ORDER_DESC, noOrder.getSortOrder());

        QuerySort multipleSpaces = new QuerySort("test   ascending ");
        assertEquals("test", multipleSpaces.getSortField());
        assertEquals(QuerySort.ORDER_ASC, multipleSpaces.getSortOrder());
    }

    /**
     * Test if we properly recognize sorting functions for multi-value fields, for example field(proxy_dcterms_issued,min)
     */
    @Test
    public void testMultiValueFunctionSort() {
        QuerySort noOrder = new QuerySort("field(proxy_dcterms_issued,min)");
        assertEquals("field(proxy_dcterms_issued,min)", noOrder.getSortField());

        QuerySort withOrder = new QuerySort("FIELD(proxy_dcterms_issued,min)+ASC");
        assertEquals("FIELD(proxy_dcterms_issued,min)", withOrder.getSortField());
        assertEquals(QuerySort.ORDER_ASC, withOrder.getSortOrder());

        QuerySort withOrderAndSpaces = new QuerySort(" Field( proxy_dcterms_issued , min ) descending ");
        assertEquals("Field( proxy_dcterms_issued , min )", withOrderAndSpaces.getSortField());
        assertEquals(QuerySort.ORDER_DESC, withOrderAndSpaces.getSortOrder());
    }


}
