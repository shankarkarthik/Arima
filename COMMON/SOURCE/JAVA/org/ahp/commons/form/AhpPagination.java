package org.ahp.commons.form;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AhpPagination {
    
    final static Logger LOGGER = LoggerFactory.getLogger( AhpPagination.class );
    
    private String mSelectedPage;
    private List<PaginationResult> mPaginationResultList;
    private String hiddenSelectedComboValue;
    private String mOperation;
    private boolean mClickedPrevious;
    private boolean mClickedNext;
    
    class PaginationResult{
        /** */
        private String mPageNumber;
        /** */
        private String mPageRange;
           
        /**
         * 
         * @param pPageNumber
         * @param pPageRange
         */
        public PaginationResult( String pPageNumber, 
                                 String pPageRange ) {
            this.mPageNumber = pPageNumber;
            this.mPageRange = pPageRange;
        }

        public String getPageNumber() {
            return mPageNumber;
        }
        public void setPageNumber( String pPageNumber ) {
            mPageNumber = pPageNumber;
        }
        public String getPageRange() {
            return mPageRange;
        }
        public void setPageRange( String pPageRange ) {
            mPageRange = pPageRange;
        }
        
    }

    public String getSelectedPage() {
        return mSelectedPage;
    }

    public void setSelectedPage( String pSelectedPage ) {
        mSelectedPage = pSelectedPage;
    }

    public List<PaginationResult> getPaginationResultList() {
        return mPaginationResultList;
    }

    public void setPaginationResultList( List<PaginationResult> pPaginationResultList ) {
        mPaginationResultList = pPaginationResultList;
    }

    public String getHiddenSelectedComboValue() {
        return hiddenSelectedComboValue;
    }

    public void setHiddenSelectedComboValue( String pHiddenSelectedComboValue ) {
        hiddenSelectedComboValue = pHiddenSelectedComboValue;
    }

    public String getOperation() {
        return mOperation;
    }

    public void setOperation( String pOperation ) {
        mOperation = pOperation;
    }

    public boolean isClickedPrevious() {
        return mClickedPrevious;
    }

    public void setClickedPrevious( boolean pClickedPrevious ) {
        mClickedPrevious = pClickedPrevious;
    }

    public boolean isClickedNext() {
        return mClickedNext;
    }

    public void setClickedNext( boolean pClickedNext ) {
        mClickedNext = pClickedNext;
    }
    
    
}
