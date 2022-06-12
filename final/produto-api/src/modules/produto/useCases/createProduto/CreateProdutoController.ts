import { Request, Response } from "express";

import { CreateProdutoUseCase } from "./CreateProdutoUseCase";

class CreateProdutoController {
  constructor(private createProdutoUseCase: CreateProdutoUseCase) {}

  handle(request: Request, response: Response): Response {
    const { nome, descricao, preco } = request.body;

    this.createProdutoUseCase.execute({ nome, descricao, preco });

    return response.status(201).send();
  }
}

export { CreateProdutoController };
