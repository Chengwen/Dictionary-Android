package com.miracle.dictionary;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class SingleWord
{
	public int id;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int dictinfoid;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String word;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String content;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */

    public SingleWord(int id,int dictinfoid,String word,String content) {  
        this.id = id;   
        this.dictinfoid = dictinfoid;  
        this.word = word;  
        this.content = content;  
    } 
    public SingleWord() {  
       
    } 
}

