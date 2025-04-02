package com.example.monsqlite;

import android.content.Context;
import android.graphics.Canvas;
import android.util.TypedValue;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class EffetSwipe extends ItemTouchHelper.SimpleCallback {
    private Context context;
    private List<Items> itemS;
    private MonAdapter mAdapter;

    public EffetSwipe(int dragDirs, int swipeDirs, Context context, List<Items> itemS, MonAdapter mAdapter) {
        super(dragDirs, swipeDirs);
        this.context = context;
        this.itemS = itemS;
        this.mAdapter = mAdapter;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int pos = viewHolder.getAdapterPosition();
        itemS.remove(pos);
        Toast.makeText(context,
                "Swipe affichage Position " + pos, Toast.LENGTH_SHORT).show();
        mAdapter.notifyItemRemoved(pos);
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY,
                            int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                .addSwipeLeftBackgroundColor(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.swipe_bg_trash))
                .addSwipeLeftActionIcon(R.drawable.poubelle70px)
                .addSwipeRightBackgroundColor(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.swipe_bg_archive))
                .addSwipeRightActionIcon(R.drawable.archivage70px)
                .addCornerRadius(TypedValue.COMPLEX_UNIT_DIP, 20)
                .create()
                .decorate();
    }
}

