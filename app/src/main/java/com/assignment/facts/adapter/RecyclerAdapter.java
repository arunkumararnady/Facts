package com.assignment.facts.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.facts.LogUtil;
import com.assignment.facts.R;
import com.assignment.facts.data.RowData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    private List<RowData> rowsModels;

    public RecyclerAdapter(Context context, List<RowData> rowsModels) {
        this.context = context;
        this.rowsModels = rowsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final @NonNull ViewHolder holder, int position) {
        final RowData rowsModelObj = rowsModels.get(position);
        holder.itemTitle.setText(rowsModelObj.getTitle());
        holder.description.setText(rowsModelObj.getDescription());

        if (rowsModelObj.getImageURL() == null) {
            holder.imageView.setVisibility(View.GONE);
        } else {
            holder.imageView.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(rowsModelObj.getImageURL())
                    .listener(requestListener)
                    .placeholder(R.drawable.ic_image_place_holder)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error(R.drawable.error)
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return rowsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView itemTitle, description;
        final ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageContainer);
        }
    }

    private RequestListener<String, GlideDrawable> requestListener = new RequestListener<String, GlideDrawable>() {
        @Override
        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
            LogUtil.error(RecyclerAdapter.class.getName(), e.getMessage());
            // important to return false so the error placeholder can be placed
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            return false;
        }
    };
}
