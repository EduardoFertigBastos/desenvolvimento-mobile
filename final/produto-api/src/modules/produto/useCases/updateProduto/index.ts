import { ProdutoRepository } from "../../repositories/ProdutoRepository";
import { UpdateProdutoController } from "./UpdateProdutoController";
import { UpdateProdutoUseCase } from "./UpdateProdutoUseCase";

const produtoRepository = ProdutoRepository.getInstance();
const updateProdutoUseCase = new UpdateProdutoUseCase(produtoRepository);
const updateProdutoController = new UpdateProdutoController(
  updateProdutoUseCase
);

export { updateProdutoController };
