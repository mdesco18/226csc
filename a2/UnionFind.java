
public class UnionFind
{
    int n;
    int [] parent;

/*  
    Make a new union/find data structure.
    Each vertex is initially in a component with itself.
*/
    public UnionFind(int n_vertex)
    {
       int i;

       n= n_vertex;
       parent= new int[n_vertex];

       for (i=0; i < n; i++)
           parent[i]=i;
    }

/*
    Returns true if u and v are in the same component
    and false otherwise.
*/

    public boolean same_component(int u, int v)
    {
        if (parent[u]== parent[v]) return(true);
        else return(false);
    }

/* 
    Update components to reflect the addition of edge (u, v).
*/

    public void union(int u, int v)
    {
        int i, min, max;

//      Just return if u and v are already in the same component.

        if (parent[u] ==  parent[v]) return;

/* 
        Otherwise, update the data structure.
*/

        if (parent[u] < parent[v])
        {
            min= parent[u];
            max= parent[v];
        }
        else
        {
            min= parent[v];
            max= parent[u];
        }
		
        for (i=0; i < n; i++)
        {
            if (parent[i]== max) parent[i]= min;
        }
		
		/*
		 if (parent[u]== max) parent[u]= min;
		 if (parent[v]== max) parent[v]= min;
		 */
    }	
}
