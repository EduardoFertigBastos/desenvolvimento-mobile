import { ProdutoRepository } from "../../repositories/ProdutoRepository";
import { CreateProdutoController } from "./CreateProdutoController";
import { CreateProdutoUseCase } from "./CreateProdutoUseCase";

const produtoRepository = ProdutoRepository.getInstance();
const createProdutoUseCase = new CreateProdutoUseCase(produtoRepository);
const createProdutoController = new CreateProdutoController(
  createProdutoUseCase
);

export { createProdutoController };
