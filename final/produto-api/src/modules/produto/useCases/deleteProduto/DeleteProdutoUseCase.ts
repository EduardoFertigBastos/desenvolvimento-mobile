import { ProdutoRepository } from "../../repositories/ProdutoRepository";

class DeleteProdutoUseCase {
  constructor(private produtosRepository: ProdutoRepository) {}
  execute(id: string) {
    this.produtosRepository.delete(id);
  }
}

export { DeleteProdutoUseCase };
