package com.example.calculator.databinding;
import com.example.calculator.R;
import com.example.calculator.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.contenido, 2);
        sViewsWithIds.put(R.id.boton1, 3);
        sViewsWithIds.put(R.id.boton2, 4);
        sViewsWithIds.put(R.id.boton3, 5);
        sViewsWithIds.put(R.id.botonDividir, 6);
        sViewsWithIds.put(R.id.boton4, 7);
        sViewsWithIds.put(R.id.boton5, 8);
        sViewsWithIds.put(R.id.boton6, 9);
        sViewsWithIds.put(R.id.botonMultiplicar, 10);
        sViewsWithIds.put(R.id.boton7, 11);
        sViewsWithIds.put(R.id.boton8, 12);
        sViewsWithIds.put(R.id.boton9, 13);
        sViewsWithIds.put(R.id.botonRestar, 14);
        sViewsWithIds.put(R.id.boton0, 15);
        sViewsWithIds.put(R.id.botonPunto, 16);
        sViewsWithIds.put(R.id.botonIgual, 17);
        sViewsWithIds.put(R.id.botonSumar, 18);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[18]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (android.widget.LinearLayout) bindings[0]
            );
        this.pantalla.setTag(null);
        this.raiz.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.texto == variableId) {
            setTexto((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setTexto(@Nullable java.lang.String Texto) {
        this.mTexto = Texto;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.texto);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String texto = mTexto;
        boolean textoJavaLangObjectNull = false;
        java.lang.String textoJavaLangObjectNullJavaLangString0Texto = null;

        if ((dirtyFlags & 0x3L) != 0) {



                // read texto == null
                textoJavaLangObjectNull = (texto) == (null);
            if((dirtyFlags & 0x3L) != 0) {
                if(textoJavaLangObjectNull) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x3L) != 0) {

                // read texto == null ? "0" : texto
                textoJavaLangObjectNullJavaLangString0Texto = ((textoJavaLangObjectNull) ? ("0") : (texto));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.pantalla, textoJavaLangObjectNullJavaLangString0Texto);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): texto
        flag 1 (0x2L): null
        flag 2 (0x3L): texto == null ? "0" : texto
        flag 3 (0x4L): texto == null ? "0" : texto
    flag mapping end*/
    //end
}