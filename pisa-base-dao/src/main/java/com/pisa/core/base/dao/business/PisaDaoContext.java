package com.pisa.core.base.dao.business;

/**
 * This class holds all the information that we need to share between layers such as the 
 * user that is executing the action and the transaction id if available
 * 
 * @author PISA
 */
public class PisaDaoContext {
    
    private String user = null;
    private String transactionId = null;
    private PisaDaoPublicContext publicContext = null;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Returns an read-only instance of the current context
     * @return returns an {@linkplain PisaDaoPublicContext} which only expose read methods 
     */
    public PisaDaoPublicContext GetPublicContext(){
        if (publicContext == null)
            publicContext = new PisaDaoPublicContext(this);
        return publicContext;
    }

    /**
     * This class will be used to share the context information but
     * without letting other layers (like presentation) to modify any
     * information in it
     */
    public class PisaDaoPublicContext{
        
        private PisaDaoContext context;
        
        public PisaDaoPublicContext(PisaDaoContext context){
            this.context = context;
        }

        public String getUser() {
            return context.getUser();
        }

        public String getTransactionId() {
            return context.getTransactionId();
        }
    }
}