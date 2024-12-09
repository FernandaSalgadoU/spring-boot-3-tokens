package med.voll.api.paginacion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

//USADO PARA REEMPLAZAR PAGE
public record DatosPaginacion<T>(
        List<T> content,
        PageableInfo pageable,
        boolean last,
        long totalElements,
        int totalPages,
        boolean first,
        int size,
        int number,
        SortInfo sort,
        int numberOfElements,
        boolean empty
) {
    public DatosPaginacion(Page<T> pagina) {
        this(
                pagina.getContent(),
                new PageableInfo(pagina.getPageable()),
                pagina.isLast(),
                pagina.getTotalElements(),
                pagina.getTotalPages(),
                pagina.isFirst(),
                pagina.getSize(),
                pagina.getNumber(),
                new SortInfo(pagina.getSort()),
                pagina.getNumberOfElements(),
                pagina.isEmpty()
        );
    }

    public record PageableInfo(
            int pageNumber,
            int pageSize,
            long offset,
            boolean paged,
            boolean unpaged
    ) {
        public PageableInfo(Pageable pageable) {
            this(
                    pageable.getPageNumber(),
                    pageable.getPageSize(),
                    pageable.getOffset(),
                    pageable.isPaged(),
                    pageable.isUnpaged()
            );
        }
    }

    public record SortInfo(
            boolean empty,
            boolean sorted,
            boolean unsorted
    ) {
        public SortInfo(Sort sort) {
            this(
                    sort.isEmpty(),
                    sort.isSorted(),
                    sort.isUnsorted()
            );
        }
    }
}
