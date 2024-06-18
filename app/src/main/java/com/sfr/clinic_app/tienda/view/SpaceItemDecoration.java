package com.sfr.clinic_app.tienda.view;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int space;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left = space / 2;
        outRect.right = space / 2;
        outRect.bottom = space;

        // Agregar espacio en la parte superior solo para los elementos de la primera fila
        if (parent.getChildAdapterPosition(view) < 2) {
            outRect.top = space;
        } else {
            outRect.top = 0;
        }
    }
}
